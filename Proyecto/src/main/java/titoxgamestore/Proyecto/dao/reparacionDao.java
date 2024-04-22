
package titoxgamestore.Proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import titoxgamestore.Proyecto.domain.reparacion;

import java.util.List;


public interface reparacionDao extends JpaRepository <reparacion, Long>{

    List<reparacion> findBycorreo_electronico(String correo_electronico);
    
}
