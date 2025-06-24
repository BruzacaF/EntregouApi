package Entregou.database.controller;

import Entregou.database.model.Cliente;
import org.springframework.web.bind.annotation.RestController;
import Entregou.database.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente novo) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setUsuario(novo.getUsuario());
            return clienteRepository.save(cliente);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }


}
