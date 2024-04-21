/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package titoxgamestore.Proyecto.service.impl;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import titoxgamestore.Proyecto.dao.catalogoDao;
import titoxgamestore.Proyecto.domain.catalogo;


/**
 *
 * @author stgue
 */
public class catalogoServiceImpl {
    @Autowired
    private catalogoDao catalogodao;

    
    @Transactional(readOnly = true)
    public List<catalogo> getcatalogo (boolean activos) {
        var lista = catalogodao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Transactional(readOnly = true)
    public catalogo getcatalogo(catalogo catalogo) {
        return catalogodao.findById(catalogo.getId_catalogo()).orElse(null);
    }

    @Transactional
    public void save(catalogo catalogo) {
        catalogodao.save(catalogo);
    }

    
    @Transactional
    public void delete(catalogo catalogo) {
        catalogodao.delete(catalogo);
    }
}
