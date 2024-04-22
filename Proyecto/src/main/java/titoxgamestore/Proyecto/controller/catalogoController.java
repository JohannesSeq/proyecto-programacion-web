package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import titoxgamestore.Proyecto.service.catalogoService;
import titoxgamestore.Proyecto.domain.catalogo;

import java.util.List;


@Controller
@RequestMapping("/catalogo")
public class catalogoController {

    @Autowired
    private catalogoService catalogoService;

    @GetMapping("/Catalogo")
    public String listado(@RequestParam(name = "filtro", required = false, defaultValue = "all") String filtro, Model model) {
        List<catalogo> catalogo;
        if (filtro == null || filtro.equals("all")) {
            catalogo = catalogoService.getcatalogo(false);
        } else {
            catalogo = catalogoService.getFilterCatalogo(filtro);
        }
        model.addAttribute("catalogoItems", catalogo);
        model.addAttribute("totalCatalogo", catalogo.size());
        model.addAttribute("currentFilter", filtro);
        return "catalogo/Catalogo";
    }

    @GetMapping("/CatalogoAdministrador")
    public String listadoAdministrador(Model model) {
        List<catalogo> catalogo = catalogoService.getcatalogo(false);

        model.addAttribute("catalogoItems", catalogo);
        model.addAttribute("totalCatalogo", catalogo.size());
        model.addAttribute("catalogo", new catalogo());
        return "catalogo/listaCatalogoAdministrador";
    }
    
     @GetMapping("/nuevo")
    public String CatalogoNuevo(catalogo catalogo) {
        return "/catalogo/modifica";
    }

    @PostMapping("/guardar")
    public String CatalogoGuardar(catalogo catalogo) {
        catalogoService.save(catalogo);
        return "redirect:/catalogo/Catalogo";
    }

    @GetMapping("/eliminar/{id_catalogo}")
    public String catalogoEliminar(catalogo catalogo) {
        catalogoService.delete(catalogo);
        return "redirect:/catalogo/Catalogo";
    }

    @PostMapping("/modificar")
    public String modificarCatalogo(@ModelAttribute("catalogo") catalogo catalogo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("catalogo", catalogo);
            return "/catalogo/modifica"; // Redirect back to modification page if there are form errors
        }

        try {
            catalogoService.update(catalogo); // Assuming this method checks if ID is present and throws IllegalArgumentException if not
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "/catalogo/modifica"; // Redirect back to modification page if there are service errors
        }
        return "redirect:/catalogo/CatalogoAdministrador"; // Redirect after successful update
    }

    @GetMapping("/modificar/{id_catalogo}")
    public String catalogoModificar(catalogo catalogo, Model model) {
        catalogo = catalogoService.getcatalogo(catalogo);
        model.addAttribute("catalogo", catalogo);
        return "/catalogo/modifica";
    }

}
