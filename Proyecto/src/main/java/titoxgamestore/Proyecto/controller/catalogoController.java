package titoxgamestore.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import titoxgamestore.Proyecto.service.catalogoService;
import titoxgamestore.Proyecto.domain.catalogo;


@Controller
@RequestMapping("/catalogo")
public class catalogoController {
    @Autowired
    private catalogoService catalogoService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var catalogo = catalogoService.getcatalogo(false);
        model.addAttribute("catalogo", catalogo);
        model.addAttribute("totalcatalogo",catalogo.size());
        return "/catalogo/listado";
    }
    
     @GetMapping("/nuevo")
    public String CatalogoNuevo(catalogo catalogo) {
        return "/condominio/modifica";
    }

    @PostMapping("/guardar")
    public String CatalogoGuardar(catalogo catalogo) {
        catalogoService.save(catalogo);
        return "redirect:/catalogo/listado";
    }

    @GetMapping("/eliminar/{id_catalogo}")
    public String catalogoEliminar(catalogo catalogo) {
        catalogoService.delete(catalogo);
        return "redirect:/catalogo/listado";
    }

    @GetMapping("/modificar/{id_catalogo}")
    public String catalogoModificar(catalogo catalogo, Model model) {
        catalogo = catalogoService.getcatalogo(catalogo);
        model.addAttribute("catalogo", catalogo);
        return "/catalogo/modifica";
    }

}
