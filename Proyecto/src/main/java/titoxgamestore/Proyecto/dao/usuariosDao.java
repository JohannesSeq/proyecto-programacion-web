package titoxgamestore.Proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import titoxgamestore.Proyecto.domain.usuarios;

public interface usuariosDao extends JpaRepository<usuarios, Long> {

    usuarios findByUsuario(String usuario);

    usuarios findByUsuarioAndPassword(String usuario, String password);

    usuarios findByUsuarioOrCorreo(String usuario, String correo);

    boolean existsByUsuarioOrCorreo(String usuario, String correo);
}