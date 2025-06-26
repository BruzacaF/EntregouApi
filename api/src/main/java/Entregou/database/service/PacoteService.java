package Entregou.database.service;



import Entregou.database.dto.PacoteResponse;
import Entregou.database.model.Cliente;
import Entregou.database.model.Pacote;
import Entregou.database.model.Usuario;
import Entregou.database.dto.PacoteRequest;
import Entregou.database.repository.ClienteRepository;
import Entregou.database.repository.PacoteRepository;
import Entregou.database.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    private PacoteRepository pacoteRepository;
    private UsuarioRepository usuarioRepository;
    private ClienteRepository clienteRepository;

    public PacoteService(PacoteRepository pacoteRepository,
                         UsuarioRepository usuarioRepository,
                         ClienteRepository clienteRepository) {
        this.pacoteRepository = pacoteRepository;
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
    }

    public void adicionarPacote(String emailUsuario, PacoteRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario autenticado nao encontrado");
        }

        Cliente remetente = clienteRepository.findByUsuario(usuario);
        if (remetente == null) {
            throw new RuntimeException("Cliente nao encontrado");
        }

        Cliente destinatario = clienteRepository.findById(request.getIdClienteDestinatario())
                .orElseThrow(() -> new RuntimeException("Destinatario nao esta cadastrado como cliente"));



        Pacote pacote = new Pacote();

        pacote.setIdClienteRemetente(remetente);
        pacote.setIdClienteDestinatario(destinatario);
        pacote.setTipoPacote(request.getTipoPacote());
        pacote.setDimensoes(request.getDimensoes());
        pacote.setPeso(request.getPeso());
        pacote.setValorDeclarado(request.getValorDeclarado());
        pacote.setDescricaoConteudo(request.getDescricaoConteudo());
        pacote.setTipoEmbalagem(request.getTipoEmbalagem());
        pacote.setPrioridade(request.getPrioridade());

        pacoteRepository.save(pacote);
    }

    public List<PacoteResponse> listarMeusPacotesEnviados(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        Cliente cliente = clienteRepository.findByUsuario(usuario);

        List<Object[]> resultados = pacoteRepository.buscarEnviadosPorCliente(cliente.getId());

        return resultados.stream()
                .map(obj -> new PacoteResponse(
                        (String) obj[0],  // nomeDestinatario
                        (String) obj[1],  // nomeRemetente
                        (String) obj[2],  // tipoPacote
                        (String) obj[3],  // codigoRastreio
                        (String) obj[4],  // descricaoConteudo
                        (Boolean) obj[5]   // prioridade
                )).toList();
    }

//    public List<PacoteResponse> listarMeusPacotesRecebidos(String email){
//        Usuario usuario = usuarioRepository.findByEmail(email);
//        Cliente cliente = clienteRepository.findByUsuario(usuario);
//
//        return pacoteRepository.buscarRecebidosPorCliente(cliente.getId()).stream()
//                .map(pacote -> new PacoteResponse(
//                        pacote.getIdClienteDestinatario().getUsuario().getNome(),
//                        pacote.getIdClienteRemetente().getUsuario().getNome(),
//                        pacote.getTipoPacote(),
//                        pacote.getCodigoRastreio(),
//                        pacote.getDescricaoConteudo(),
//                        pacote.getPrioridade()
//                        )).toList();
//    }
}

