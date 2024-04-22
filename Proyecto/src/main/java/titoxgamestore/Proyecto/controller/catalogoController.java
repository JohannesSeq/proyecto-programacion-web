package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            catalogo = catalogoService.getcatalogo(false); // Get all catalogo items without any filter
        } else {
            catalogo = catalogoService.getFilterCatalogo(filtro); // Get filtered catalogo items
        }
        model.addAttribute("catalogoItems", catalogo);
        model.addAttribute("totalCatalogo", catalogo.size());
        model.addAttribute("currentFilter", filtro); // Pass the current filter back to the view
        return "catalogo/Catalogo";
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

    @GetMapping("/modificar/{id_catalogo}")
    public String catalogoModificar(catalogo catalogo, Model model) {
        catalogo = catalogoService.getcatalogo(catalogo);
        model.addAttribute("catalogo", catalogo);
        return "/catalogo/modifica";
    }

}
