package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.backend.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
