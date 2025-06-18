package Entregou.database.service;

import Entregou.database.dto.*;
import Entregou.database.model.Usuario;
import Entregou.database.repository.UsuarioRepository;

import Entregou.database.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UsuarioRepository usuarioRepository, JwtUtil jwtUtil){
        this.usuarioRepository = usuarioRepository;
        this.encoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse cadastrar(RegisterRequest request){
        if(usuarioRepository.findByEmail(request.getEmail()) != null){
            throw new RuntimeException("Email ja cadastrado");
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setNome(request.getNome());
        usuario.setSenhaHash(encoder.encode(request.getSenha()));
        usuario.setRole(request.getRole());

        usuarioRepository.save(usuario);

        String token = jwtUtil.gerarToken(usuario.getEmail(), usuario.getRole());
        return new AuthResponse(token, usuario.getRole());
    }

    public AuthResponse logar(LoginRequest request){
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail());

        if (usuario == null || !encoder.matches(request.getPassword(), usuario.getSenhaHash())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        String token = jwtUtil.gerarToken(usuario.getEmail(), usuario.getRole());
        return new AuthResponse(token, usuario.getRole());
    }

    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }


}
