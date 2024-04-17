package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.backend.model.Administrador;



@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Administrador findByEmail(String email);
}
