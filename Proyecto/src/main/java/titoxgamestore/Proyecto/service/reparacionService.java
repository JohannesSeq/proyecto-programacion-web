
package titoxgamestore.Proyecto.service;

import java.util.List;
import titoxgamestore.Proyecto.domain.reparacion;

public interface reparacionService {

    public List<reparacion> getreparacion(boolean activos);

    public List<reparacion> getreparacionPorEmail(String correo_electronico);

    public reparacion getreparacion(reparacion reparacion);
    public void save(reparacion reparacion);
    public void delete(reparacion reparacion);
}
