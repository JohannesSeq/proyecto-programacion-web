
package titoxgamestore.Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="reparaciones")
public class reparacion implements Serializable{
    
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reparacion_id")
    private long reparacion_id;
    private String nombre;
    private String apellido;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    private String Detalles_Reparacion;
    private boolean activo;

    public reparacion() {
    }
    
    

    public reparacion(long reparacion_id,String nombre, String apellido, String correoElectronico, Date fecha, String Detalles_Reparacion, boolean activo) {
        this.reparacion_id = reparacion_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.fecha = fecha;
        this.Detalles_Reparacion = Detalles_Reparacion;
        this.activo = activo;
    }

    

    

    
    
    
    
    
    
}
