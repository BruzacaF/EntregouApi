package Entregou.database.repository;

import Entregou.database.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    Page<Entrega> findAll(Pageable pageable);

    @Query("Select e from Entrega e where e.motorista.id = :idUsuario")
    List<Entrega> findByMotoristaId(@Param("idUsuario") Long idUsuario);

}