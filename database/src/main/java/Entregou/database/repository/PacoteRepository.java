package Entregou.database.repository;

import Entregou.database.dto.PacoteResponse;
import Entregou.database.model.Cliente;
import Entregou.database.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

    @Query(value = """
    SELECT 
        u_dest.nome AS nomeDestinatario, 
        u_rem.nome AS nomeRemetente, 
        p.tipo_pacote, 
        p.codigo_rastreio, 
        p.descricao_conteudo, 
        p.prioridade
    FROM pacote p
    JOIN cliente c_rem ON c_rem.id_usuario = p.id_cliente_remetente
    JOIN cliente c_dest ON c_dest.id_usuario = p.id_cliente_destinatario
    JOIN usuario u_rem ON u_rem.id = c_rem.id_usuario
    JOIN usuario u_dest ON u_dest.id = c_dest.id_usuario
    WHERE p.id_cliente_remetente = :idCliente
    """, nativeQuery = true)
    List<Object[]> buscarEnviadosPorCliente(@Param("idCliente") Long idCliente);



}