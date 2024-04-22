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
    public usuarios getUsuarioPorUsuario(String usuario) {
        return usuariosDao.findByUsuario(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public usuarios getUsuarioPorUsuarioYPassword(String usuario, String password) {
        return usuariosDao.findByUsuarioAndPassword(usuario, password);
    }

    @Override
    @Transactional(readOnly = true)
    public usuarios getUsuarioPorUsuarioOCorreo(String usuario, String correo) {
        return usuariosDao.findByUsuarioOrCorreo(usuario, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsuarioOCorreo(String usuario, String correo) {
        return usuariosDao.existsByUsuarioOrCorreo(usuario, correo);
    }

    @Override
    @Transactional
    public void save(usuarios usuario, boolean crearRolUser) {
        usuario = usuariosDao.save(usuario);
        if (crearRolUser) {
            rol Rol = new rol();
            Rol.setNombre("USER");
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