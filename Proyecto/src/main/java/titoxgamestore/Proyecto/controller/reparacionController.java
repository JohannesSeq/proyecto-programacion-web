
package titoxgamestore.Proyecto.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import titoxgamestore.Proyecto.service.reparacionService;

@Controller
@Slf4j
@RequestMapping("/FormReparaciones")
public class reparacionController {
    
    @Autowired
    private reparacionService reparacioService; 
    
    public String inicio(Model model){
        var reparaciones = reparacionService.getreparacion(false);
                }
    
}
