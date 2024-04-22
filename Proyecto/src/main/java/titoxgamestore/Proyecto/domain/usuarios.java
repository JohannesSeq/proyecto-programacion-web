package titoxgamestore.Proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String usuario;
    @NotEmpty
    private String password;
    private String correo;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<rol> roles;
}
