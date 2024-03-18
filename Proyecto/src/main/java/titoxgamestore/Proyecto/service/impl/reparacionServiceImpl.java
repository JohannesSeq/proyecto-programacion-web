/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package titoxgamestore.Proyecto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import titoxgamestore.Proyecto.dao.reparacionDao;
import titoxgamestore.Proyecto.domain.reparacion;
import titoxgamestore.Proyecto.service.reparacionService;


@Service
public class reparacionServiceImpl implements reparacionService{
    
    @Autowired
    private reparacionDao reparacionDao;
    
    
    public List<reparacion> getreparacion(boolean activos){
        var lista=reparacionDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
}
