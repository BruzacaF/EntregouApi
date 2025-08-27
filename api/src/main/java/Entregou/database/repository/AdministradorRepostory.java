package Entregou.database.repository;

import Entregou.database.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepostory extends JpaRepository<Administrador, Long> {
}
