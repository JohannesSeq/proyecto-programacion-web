package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import titoxgamestore.Proyecto.domain.usuarios;
import titoxgamestore.Proyecto.service.usuarioService;

@Controller
@RequestMapping("/usuario")
public class usuariosController {

    @Autowired
    private usuarioService UsuarioService;

    @GetMapping("/login")
    public String login(Model model) {
        return "/usuario/login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        return "/usuario/signup";
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = UsuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";
    }

    @GetMapping("/nuevo")
    public String usuarioNuevo(usuarios usuario) {
        return "/usuario/modifica";
    }


    @PostMapping("/guardar")
    public String usuarioGuardar(usuarios usuario, @RequestParam("imagenFile") MultipartFile imagenFile) {

        UsuarioService.save(usuario,true);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(usuarios usuario) {
        UsuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(usuarios usuario, Model model) {
        usuario = UsuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}
