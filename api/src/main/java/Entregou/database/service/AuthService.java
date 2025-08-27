package Entregou.database.service;

import Entregou.database.dto.*;
import Entregou.database.model.Administrador;
import Entregou.database.model.Cliente;
import Entregou.database.model.Motorista;
import Entregou.database.model.Usuario;
import Entregou.database.repository.AdministradorRepostory;
import Entregou.database.repository.ClienteRepository;
import Entregou.database.repository.MotoristaRepository;
import Entregou.database.repository.UsuarioRepository;

import Entregou.database.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final MotoristaRepository motoristaRepository;
    private final AdministradorRepostory administradorRepostory;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil, UsuarioRepository usuarioRepository, ClienteRepository clienteRepository,
                       AdministradorRepostory administradorRepostory, MotoristaRepository motoristaRepository){
        this.usuarioRepository = usuarioRepository;
        this.encoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
        this.clienteRepository = clienteRepository;
        this.administradorRepostory = administradorRepostory;
        this.motoristaRepository = motoristaRepository;
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

        this.criaSubtiposDeUsuariosDeTeste(usuario);

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

    private void criaSubtiposDeUsuariosDeTeste(Usuario usuario){
        switch (usuario.getRole()) {
            case CLIENTE:
                Cliente cliente = new Cliente();
                cliente.setUsuario(usuario);
                cliente.setTipoPessoa("F");
                cliente.setCpfCnpj("000.000.000-00");
                clienteRepository.save(cliente);
                break;

            case MOTORISTA:
                Motorista motorista = new Motorista();
                motorista.setUsuario(usuario);
                motorista.setCategoriaCnh("B");
                motoristaRepository.save(motorista);
                break;

            case ADMIN:
                Administrador admin = new Administrador();
                admin.setUsuario(usuario);
                admin.setUltimoLogin(LocalDateTime.now());
                administradorRepostory.save(admin);
                break;
        }

    }
}
