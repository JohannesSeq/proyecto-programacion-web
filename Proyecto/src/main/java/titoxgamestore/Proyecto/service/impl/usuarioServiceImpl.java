package titoxgamestore.Proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import titoxgamestore.Proyecto.dao.rolDao;
import titoxgamestore.Proyecto.dao.usuariosDao;
import titoxgamestore.Proyecto.domain.rol;
import titoxgamestore.Proyecto.domain.usuarios;
import titoxgamestore.Proyecto.service.usuarioService;

import java.util.List;

@Service
public class usuarioServiceImpl implements usuarioService {

    @Autowired
    private usuariosDao usuariosDao;

    @Autowired
    private rolDao roldao;

    @Override
    @Transactional(readOnly = true)
    public List<usuarios> getUsuarios() {
        return usuariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public usuarios getUsuario(usuarios usuario) {
        return usuariosDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public usuarios getUsuarioPorUsername(String username) {
        return usuariosDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public usuarios getUsuarioPorUsernameYPassword(String username, String password) {
        return usuariosDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public usuarios getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuariosDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuariosDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(usuarios usuario, boolean crearRolUser) {
        usuario=usuariosDao.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            rol Rol = new rol();
            Rol.setNombre("ROLE_USER");
            Rol.setIdUsuario(usuario.getIdUsuario());
            roldao.save(Rol);
        }
    }

    @Override
    @Transactional
    public void delete(usuarios usuario) {
        usuariosDao.delete(usuario);
    }
}
