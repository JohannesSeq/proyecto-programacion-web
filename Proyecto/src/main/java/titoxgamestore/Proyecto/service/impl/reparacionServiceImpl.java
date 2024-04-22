/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package titoxgamestore.Proyecto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import titoxgamestore.Proyecto.dao.reparacionDao;
import titoxgamestore.Proyecto.domain.reparacion;
import titoxgamestore.Proyecto.service.reparacionService;


@Service
public class reparacionServiceImpl implements reparacionService{
    
    @Autowired
    private reparacionDao reparaciondao;
    
    @Transactional(readOnly = true)
    @Override
    public List<reparacion> getreparacion(boolean activos){
        var lista=reparaciondao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    @Transactional(readOnly = true)
    @Override
    public List<reparacion> getreparacionPorEmail(String correo_electronico) {
        var lista = reparaciondao.findBycorreo_electronico(correo_electronico);
        return lista;
    }


    @Transactional(readOnly = true)
    @Override
    public reparacion getreparacion(reparacion reparacion) {
        return reparaciondao.findById(reparacion.getReparacion_id()).orElse(null);
    }
    
    
    @Transactional
    @Override
    public void save(reparacion reparacion) {
        reparaciondao.save(reparacion);
    }
    
    
    @Transactional
    @Override
    public void delete(reparacion reparacion) {
        reparaciondao.delete(reparacion);
    }
}
