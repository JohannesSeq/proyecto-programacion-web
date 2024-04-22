/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package titoxgamestore.Proyecto.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import titoxgamestore.Proyecto.dao.catalogoDao;
import titoxgamestore.Proyecto.domain.catalogo;
import titoxgamestore.Proyecto.service.catalogoService;


/**
 *
 * @author stgue
 */
@Service
public class catalogoServiceImpl implements catalogoService{

    @Autowired
    private catalogoDao catalogodao;

    
    @Transactional(readOnly = true)
    @Override
    public List<catalogo> getcatalogo (boolean activos) {
        var lista = catalogodao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    @Transactional(readOnly = true)
    @Override
    public List<catalogo> getFilterCatalogo(String filtro) {
        if (filtro == null || filtro.equals("all")) {
            return catalogodao.findAll(); // Use the correct instance variable name
        } else {
            return catalogodao.findByTipoArticulo(filtro); // Use the correct instance variable name
        }
    }

    @Transactional(readOnly = true)
    @Override
    public catalogo getcatalogo(catalogo catalogo) {
        return catalogodao.findById(catalogo.getId_catalogo()).orElse(null);
    }



    @Transactional
    @Override
    public void save(catalogo catalogo) {
        catalogodao.save(catalogo);
    }

    
    @Transactional
    @Override
    public void delete(catalogo catalogo) {
        catalogodao.delete(catalogo);
    }
}
