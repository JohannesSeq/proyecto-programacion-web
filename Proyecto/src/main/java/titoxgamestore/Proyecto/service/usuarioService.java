package titoxgamestore.Proyecto.service;

import titoxgamestore.Proyecto.domain.usuarios;

import java.util.List;

public interface usuarioService {

    // Retrieves a list of users
    List<usuarios> getUsuarios();

    // Retrieves a user based on user ID
    usuarios getUsuario(usuarios usuario);

    // Retrieves a user based on username (now referred to by the 'usuario' field)
    usuarios getUsuarioPorUsuario(String usuario);

    // Retrieves a user based on username and password
    usuarios getUsuarioPorUsuarioYPassword(String usuario, String password);

    // Retrieves a user based on username or email
    usuarios getUsuarioPorUsuarioOCorreo(String usuario, String correo);

    // Checks if a user exists based on username or email
    boolean existeUsuarioPorUsuarioOCorreo(String usuario, String correo);

    // Inserts a new user if the user ID is empty, updates if not
    void save(usuarios usuario, boolean crearRolUser);

    // Deletes a user based on ID
    void delete(usuarios usuario);
}