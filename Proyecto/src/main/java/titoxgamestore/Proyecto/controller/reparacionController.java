
package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import titoxgamestore.Proyecto.service.reparacionService;

@Controller
@RequestMapping("/FormReparaciones")
public class reparacionController {
    
    @Autowired
    private reparacionService reparacioService;

    @GetMapping("/listado")
    private String listado(Model model){
        var reparaciones = reparacioService.getreparacion(false);

        return "/reparaciones/listado";
    }
}
