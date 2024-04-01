package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.backend.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
