
package titoxgamestore.Proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import titoxgamestore.Proyecto.domain.reparacion;

import java.util.List;


public interface reparacionDao extends JpaRepository <reparacion, Long>{

    List<reparacion> findByCorreoElectronico(@Param("correoElectronico") String correoElectronico);


}
