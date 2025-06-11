package Entregou.database.controller;

import org.springframework.web.bind.annotation.RestController;
import Entregou.database.model.Entrega;
import Entregou.database.repository.EntregaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entregas")
class EntregaController {
    private final EntregaRepository entregaRepository;

    public EntregaController(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @GetMapping
    public List<Entrega> listar() {
        return entregaRepository.findAll();
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
            entrega.setDataSaida(novo.getDataSaida());
            entrega.setDataEntrega(novo.getDataEntrega());
            entrega.setObservacoes(novo.getObservacoes());
            entrega.setMotorista(novo.getMotorista());
            entrega.setPacote(novo.getPacote());
            entrega.setStatus(novo.getStatus());
            return entregaRepository.save(entrega);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        entregaRepository.deleteById(id);
    }

}
