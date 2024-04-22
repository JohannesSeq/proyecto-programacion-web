package titoxgamestore.Proyecto.service;

import titoxgamestore.Proyecto.domain.catalogo;
import java.util.List;

public interface catalogoService {
    public List<catalogo> getcatalogo(boolean activo);

    public List<catalogo> getFilterCatalogo(String filtro);

    public catalogo getcatalogo(catalogo catalogo);

    public void save(catalogo catalogo);

    void update(catalogo catalogo); // Add this if implementing an explicit update method

    public void delete(catalogo catalogo);
}
