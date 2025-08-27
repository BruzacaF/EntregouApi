package Entregou.database.controller;

import Entregou.database.dto.PacoteRequest;
import Entregou.database.dto.PacoteResponse;
import Entregou.database.model.Pacote;
import Entregou.database.service.PacoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pacotes")
@PreAuthorize("hasRole('CLIENTE')")
class PacoteController {

    private final PacoteService pacoteService;

    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @PostMapping
    public ResponseEntity<Void> addPacote(@RequestBody PacoteRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        pacoteService.adicionarPacote(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/meusPacotes")
    public List<PacoteResponse> listarMeusPacotes(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return pacoteService.listarMeusPacotesEnviados(email);

    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        pacoteService.removerPorId(id);
    }


//    @GetMapping("/destinatario")
//    public List<PacoteResponse> listarMeusPacotesDestinatario(){
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();
//        return pacoteService.listarMeusPacotesRecebidos(email);
//    }

}
