
package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import titoxgamestore.Proyecto.service.impl.CustomUserDetails;
import titoxgamestore.Proyecto.service.reparacionService;
import titoxgamestore.Proyecto.domain.reparacion;

@Controller
@RequestMapping("/reparaciones")
public class reparacionController {
    
    @Autowired
    private reparacionService reparacionservice;

    @GetMapping("/mostrarForm")
    public String mostrarForm() {
        return "/reparaciones/FormReparaciones";
    }

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
        reparacion.setActivo(true);
        reparacionservice.save(reparacion);
        return "redirect:/reparaciones/mostrarForm?exito";
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

    @GetMapping("/porEmail")
    public String getReparacionesPorEmail(Model model, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String email = userDetails.getEmail();

        var reparaciones = reparacionservice.getreparacionPorEmail(email);
        model.addAttribute("reparaciones", reparaciones);
        return "usuario/listadoReparaciones";
    }
    
    
}
