package titoxgamestore.Proyecto.dao;

import titoxgamestore.Proyecto.domain.catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface catalogoDao extends JpaRepository <catalogo, Long> {
    
}
