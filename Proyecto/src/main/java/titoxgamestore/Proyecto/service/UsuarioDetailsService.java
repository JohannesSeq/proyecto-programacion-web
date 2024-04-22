package titoxgamestore.Proyecto.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {

    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException;
}
