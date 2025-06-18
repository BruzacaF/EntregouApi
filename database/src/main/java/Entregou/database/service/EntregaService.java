package Entregou.database.service;

import Entregou.database.model.Entrega;
import Entregou.database.model.Motorista;

import Entregou.database.repository.EntregaRepository;
import Entregou.database.repository.MotoristaRepository;
import Entregou.database.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    private final EntregaRepository entregaRepository;
    private final UsuarioRepository usuarioRepository;
    private final MotoristaRepository motoristaRepository;

    public EntregaService(EntregaRepository entregaRepository, UsuarioRepository UsuarioRepository, MotoristaRepository motoristaRepository) {
        this.entregaRepository = entregaRepository;
        this.usuarioRepository = UsuarioRepository;
        this.motoristaRepository = motoristaRepository;
    }

    public List<Entrega> listarEntregasDoMotorista(String email) {
        Motorista motorista = motoristaRepository.findByEmail(email);
        if (motorista == null) throw new RuntimeException("Motorista não encontrado");
        return entregaRepository.findByMotoristaId(motorista.getId());
    }

}
