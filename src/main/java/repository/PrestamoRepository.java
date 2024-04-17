package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.backend.model.Prestamo;


@Repository
public interface PrestamoRepository extends JpaRepository <Prestamo, Long> {

}
