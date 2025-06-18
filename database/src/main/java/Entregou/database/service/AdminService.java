package Entregou.database.service;

import Entregou.database.dto.UsuarioResponse;
import Entregou.database.model.Usuario;
import Entregou.database.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private final UsuarioRepository usuarioRepository;

    public AdminService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponse> listarUsuarios(){
       List<Usuario> usuarios = usuarioRepository.findAll();

       return usuarios.stream()
               .map(u -> new UsuarioResponse(
                       u.getNome(),
                       u.getEmail(),
                       u.getRole()
               ))
               .collect(Collectors.toList());
    }

}
