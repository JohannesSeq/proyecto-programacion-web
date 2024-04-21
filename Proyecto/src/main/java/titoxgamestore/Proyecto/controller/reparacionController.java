
package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import titoxgamestore.Proyecto.service.reparacionService;
import titoxgamestore.Proyecto.domain.reparacion;

@Controller
@RequestMapping("/reparaciones")
public class reparacionController {
    
    @Autowired
    private reparacionService reparacionservice;

    @GetMapping("/listado")
    private String listado(Model model){
        var reparacion = reparacionservice.getreparacion(false);
        model.addAttribute("reparacion", reparacion);
        model.addAttribute("totalreparacion",reparacion.size());
        return "/reparaciones/listado";
    }
    
    
    @GetMapping("/nuevo")
    public String reparacionNuevo(reparacion reparacion) {
        return "/reparaciones/modifica";
    }
    
    
    @PostMapping("/guardar")
    public String reparacionGuardar(reparacion reparacion) {
        reparacionservice.save(reparacion);
        return "redirect:/reparaciones/listado";
    }
    
    
    @GetMapping("/eliminar/{reparacion_id}")
    public String reparacionEliminar(reparacion reparacion) {
        reparacionservice.delete(reparacion);
        return "redirect:/reparaciones/listado";
    }
    
    
    @GetMapping("/modificar/{reparacion_id}")
    public String reparacionModificar(reparacion reparacion, Model model) {
        reparacion = reparacionservice.getreparacion(reparacion);
        model.addAttribute("catalogo", reparacion);
        return "/reparaciones/modifica";
    }
    
    
}
