package Entregou.database.service;

import Entregou.database.dto.ClienteDto;
import Entregou.database.dto.UsuarioResponse;
import Entregou.database.model.Cliente;
import Entregou.database.model.Usuario;
import Entregou.database.repository.UsuarioRepository;
import Entregou.database.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;

    public AdminService(
            UsuarioRepository usuarioRepository,
    ClienteRepository clienteRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
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

    public List<ClienteDto> autocompletarClientes(String termo) {
        return clienteRepository.buscarPorNomeOuEmail(termo);
    }


}
