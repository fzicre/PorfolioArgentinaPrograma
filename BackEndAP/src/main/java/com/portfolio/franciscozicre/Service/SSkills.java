/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Service;

import com.portfolio.franciscozicre.Entity.skills;
import com.portfolio.franciscozicre.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service

public class SSkills {
    @Autowired
    RSkills rskills;
    
    public List<skills> list(){
        return rskills.findAll();
    }
    
    public Optional<skills> getOne(int id){
    return rskills.findById(id);}
    
    public Optional<skills> getByNombre(String nombre){
    return rskills.findByNombre(nombre);
    }
    
    public void save(skills skill){
    rskills.save(skill);
    }
    
    public void delete(int id){
    rskills.deleteById(id);
    }
    
    public boolean existsById(int id){
    return rskills.existsById(id);
    }
    
   public boolean existsByNombre(String nombre){
   return rskills.existsByNombre(nombre);
   }
    
}
