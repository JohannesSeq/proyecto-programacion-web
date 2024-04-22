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

    @Column(name = "tipo_articulo")
    private String tipoArticulo;

    private String imagen_catalogo;
    private int precio;
    private int cantidad;
    private boolean activo;

    public catalogo() {
    }

    public catalogo(long id_catalogo, String titulo, String descripcion, String tipoArticulo ,String imagen_catalogo, int precio ,int cantidad, boolean activo) {
        this.id_catalogo = id_catalogo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoArticulo = tipoArticulo;
        this.imagen_catalogo = imagen_catalogo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.activo = activo;
    }



}