
package titoxgamestore.Proyecto.service;

import java.util.List;
import titoxgamestore.Proyecto.domain.reparacion;

public interface reparacionService {

    public List<reparacion> getreparacion(boolean activos);

    public List<reparacion> getreparacionPorEmail(String correoElectronico);

    public reparacion getreparacionById(Long id);

    public reparacion getreparacion(reparacion reparacion);
    public void save(reparacion reparacion);

    void update(reparacion reparacion);
    public void delete(reparacion reparacion);
}
