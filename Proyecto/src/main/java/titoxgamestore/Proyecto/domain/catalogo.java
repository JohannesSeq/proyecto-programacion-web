package titoxgamestore.Proyecto.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "catalogo")
public class catalogo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private long id_catalogo;
    private String titulo;
    private String descripcion;
    private String imagen_catalogo;

    private int cantidad;
    private boolean activo;

    public catalogo() {
    }

    public catalogo(long id_catalogo, String titulo, String descripcion ,String imagen_catalogo, int cantidad, boolean activo) {
        this.id_catalogo = id_catalogo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen_catalogo = imagen_catalogo;
        this.cantidad = cantidad;
        this.activo = activo;
    }



}