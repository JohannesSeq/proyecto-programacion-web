
package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import titoxgamestore.Proyecto.service.impl.CustomUserDetails;
import titoxgamestore.Proyecto.service.reparacionService;
import titoxgamestore.Proyecto.domain.reparacion;

import java.util.List;

@Controller
@RequestMapping("/reparaciones")
public class reparacionController {
    
    @Autowired
    private reparacionService reparacionservice;

    @GetMapping("/mostrarForm")
    public String mostrarForm() {
        return "/reparaciones/FormReparaciones";
    }

    @GetMapping("/listaAdministrador")
    public String listaAdministrador(Model model){
        List<reparacion> todasReparaciones = reparacionservice.getreparacion(false);
        model.addAttribute("reparaciones", todasReparaciones);  // This should match what's used in Thymeleaf.
        return "reparaciones/listaAdministrador";  // Ensure the view name is correct.
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
        return "redirect:/reparaciones/listaAdministrador";
    }


    @GetMapping("/modificar/{reparacion_id}")
    public String reparacionModificar(@PathVariable("reparacion_id") Long id, Model model) {
        reparacion reparacion = reparacionservice.getreparacionById(id);
        if (reparacion != null) {
            model.addAttribute("reparacion", reparacion);
            return "/reparaciones/modifica";
        } else {
            // Handle the case where no reparacion is found
            return "redirect:/reparaciones/listaAdministrador"; // Or display an error message
        }
    }

    @PostMapping("/modificar/{reparacion_id}")
    public String modificarReparacion(@ModelAttribute("reparacion") reparacion reparacion) {
        if (reparacion.getReparacion_id() == 0) {
            throw new IllegalArgumentException("Reparación must have an ID for modification operations");
        }
        reparacionservice.update(reparacion);
        return "redirect:/reparaciones/listaAdministrador";  // Redirect appropriately
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
