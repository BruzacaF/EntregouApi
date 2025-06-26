package Entregou.database.repository;

import Entregou.database.dto.ClienteDto;
import Entregou.database.model.Cliente;
import Entregou.database.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByUsuario(Usuario usuario);

    @Query("""
    SELECT new Entregou.database.dto.ClienteDto(c.id, u.nome, u.email)
    FROM Cliente c
    JOIN c.usuario u
    WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :termo, '%'))
       OR LOWER(u.email) LIKE LOWER(CONCAT('%', :termo, '%'))
""")
    List<ClienteDto> buscarPorNomeOuEmail(@Param("termo") String termo);


}