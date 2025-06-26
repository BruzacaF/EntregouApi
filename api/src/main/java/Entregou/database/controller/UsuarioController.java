package Entregou.database.controller;

import Entregou.database.dto.ClienteDto;
import Entregou.database.dto.UsuarioResponse;
import Entregou.database.model.Usuario;
import Entregou.database.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import Entregou.database.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final AdminService adminService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, AdminService adminService) {
        this.usuarioRepository = usuarioRepository;
        this.adminService = adminService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UsuarioResponse> listar() {
        return adminService.listarUsuarios();
    }


    @GetMapping("/autocomplete")
    public ResponseEntity<List<ClienteDto>> autocomplete(@RequestParam String termo) {
        return ResponseEntity.ok(adminService.autocompletarClientes(termo));
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario novo) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(novo.getNome());
            usuario.setEmail(novo.getEmail());
            usuario.setSenhaHash(novo.getSenhaHash());
            usuario.setRole(novo.getRole());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

}
