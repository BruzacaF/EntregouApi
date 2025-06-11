package Entregou.database.controller;

import Entregou.database.model.Usuario;
import org.springframework.web.bind.annotation.RestController;
import Entregou.database.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
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
