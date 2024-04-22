package titoxgamestore.Proyecto.service;

import titoxgamestore.Proyecto.domain.usuarios;

import java.util.List;

public interface usuarioService {

    // Se obtiene un listado de usuarios en un List
    public List<usuarios> getUsuarios();

    // Se obtiene un Usuario, a partir del id de un usuario
    public usuarios getUsuario(usuarios usuario);

    // Se obtiene un Usuario, a partir del username de un usuario
    public usuarios getUsuarioPorUsername(String username);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public usuarios getUsuarioPorUsernameYPassword(String username, String password);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public usuarios getUsuarioPorUsernameOCorreo(String username, String correo);

    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);

    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(usuarios usuario,boolean crearRolUser);

    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(usuarios usuario);
}
