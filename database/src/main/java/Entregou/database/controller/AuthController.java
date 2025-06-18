package Entregou.database.controller;

import Entregou.database.dto.*;
import Entregou.database.model.Usuario;
import Entregou.database.service.AuthService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.cadastrar(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.logar(request);
    }

    @GetMapping("/me")
    public UserProfileResponse me() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Usuario usuario = authService.buscarPorEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario nao encontrado");
        }
        return new UserProfileResponse(usuario.getNome(), usuario.getEmail(), usuario.getRole());
    }
}
