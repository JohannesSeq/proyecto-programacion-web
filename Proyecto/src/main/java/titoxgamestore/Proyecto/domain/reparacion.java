
package titoxgamestore.Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="reparacion")
public class reparacion implements Serializable{
    
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nombre")
    private String nombre;
    private String apellido;
    private String correo_electronico ;
    private long fecha;
    private String Detalles_Reparacion;
    private boolean activo;

    public reparacion() {
    }
    
    

    public reparacion(String nombre, String apellido, String correo_electronico, long fecha, String Detalles_Reparacion, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.fecha = fecha;
        this.Detalles_Reparacion = Detalles_Reparacion;
        this.activo = activo;
    }

    

    

    
    
    
    
    
    
}
