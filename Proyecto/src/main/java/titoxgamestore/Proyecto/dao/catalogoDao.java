package titoxgamestore.Proyecto.dao;

import org.springframework.data.repository.query.Param;
import titoxgamestore.Proyecto.domain.catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface catalogoDao extends JpaRepository <catalogo, Long> {

    List<catalogo> findByTipoArticulo(@Param("tipoArticulo") String tipoArticulo);



}
