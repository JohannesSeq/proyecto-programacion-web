package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import titoxgamestore.Proyecto.service.usuarioService;

@Controller
@RequestMapping("/registro")
public class registroUsuarioController {

    @Autowired
    private usuarioService UsuarioService;

    @GetMapping("/Registro")
    public String mostrarFormularioDeRegistro() {
        return "registro/Registro";
    }

}
