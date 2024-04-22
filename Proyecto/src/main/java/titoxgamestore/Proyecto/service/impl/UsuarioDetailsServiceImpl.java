package titoxgamestore.Proyecto.service.impl;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import titoxgamestore.Proyecto.dao.usuariosDao;
import titoxgamestore.Proyecto.domain.rol;
import titoxgamestore.Proyecto.domain.usuarios;

import java.util.ArrayList;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private usuariosDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuarios usuario = usuarioDao.findByUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        var roles = new ArrayList<GrantedAuthority>();
        for (rol Rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(Rol.getNombre()));
        }

        return new CustomUserDetails(usuario.getUsuario(), usuario.getPassword(), roles, usuario.getCorreo());
    }
}
