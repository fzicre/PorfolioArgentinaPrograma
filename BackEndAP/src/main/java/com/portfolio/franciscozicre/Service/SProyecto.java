/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Service;

import com.portfolio.franciscozicre.Entity.Proyecto;
import com.portfolio.franciscozicre.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PCMR
 */
@Service
@Transactional
public class SProyecto {
    @Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
    return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre){
        return rProyecto.findByNombre(nombre);
        
    }
    
    public void save(Proyecto proyecto){
        rProyecto.save(proyecto);
        
    }
    public void delete(int id){
    rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
    return rProyecto.existsById(id);
    
    }
    
    public boolean existsByNombre(String nombre){
        return rProyecto.existsByNombre(nombre);
    }
    
}
