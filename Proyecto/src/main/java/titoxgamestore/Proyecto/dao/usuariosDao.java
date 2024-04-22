package titoxgamestore.Proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import titoxgamestore.Proyecto.domain.usuarios;

public interface usuariosDao extends JpaRepository<usuarios, Long> {

    usuarios findByUsername(String username);

    usuarios findByUsernameAndPassword(String username, String Password);

    usuarios findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}
