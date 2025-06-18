package Entregou.database.repository;

import Entregou.database.model.Motorista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

  @Query("SELECT m FROM Motorista m WHERE m.usuario.email = :email")
  Motorista findByEmail(@Param("email") String email);
}