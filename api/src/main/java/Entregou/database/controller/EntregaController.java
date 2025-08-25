package Entregou.database.controller;

import Entregou.database.service.EntregaService;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import Entregou.database.model.Entrega;
import Entregou.database.repository.EntregaRepository;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
@PreAuthorize("hasRole('MOTORISTA')")
class EntregaController {

    private final EntregaService entregaService;

    private static int paginationIndexListar;
    static {
        paginationIndexListar = 1;
    }

    private final EntregaRepository entregaRepository;

    public EntregaController(EntregaRepository entregaRepository, EntregaService entregaService) {
        this.entregaRepository = entregaRepository;
        this.entregaService = entregaService;
    }

    @GetMapping
    public Page<Entrega> listar(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        return entregaRepository.findAll(PageRequest.of(page, pageSize));
    }

    @PreAuthorize("hasRole('MOTORISTA')")
    @GetMapping("/minhas-entregas")
    public List<Entrega> minhasEntregas() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return entregaService.listarEntregasDoMotorista(email);
    }

    @PostMapping
    public Entrega criar(@RequestBody Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @GetMapping("/{id}")
    public Entrega buscar(@PathVariable Long id) {
        return entregaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Entrega atualizar(@PathVariable Long id, @RequestBody Entrega novo) {
        return entregaRepository.findById(id).map(entrega -> {
            entrega.setDataEntregaPrevista(novo.getDataEntregaPrevista());
            entrega.setDataEntregaReal(novo.getDataEntregaReal());
            entrega.setMotorista(novo.getMotorista());
            entrega.setStatusEntrega(novo.getStatusEntrega());
            return entregaRepository.save(entrega);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        entregaRepository.deleteById(id);
    }

//

}
