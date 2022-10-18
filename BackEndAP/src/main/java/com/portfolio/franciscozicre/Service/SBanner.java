/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Service;

import com.portfolio.franciscozicre.Entity.Banner;
import com.portfolio.franciscozicre.Repository.RBanner;
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
public class SBanner {
    @Autowired
    RBanner rBanner;
    
     public List<Banner> list(){
        return rBanner.findAll();
    }
    
    public Optional<Banner> getOne(int id){
    return rBanner.findById(id);
    }
    
     public Optional<Banner> getByNombre(String nombre){
        return rBanner.findByNombre(nombre);
        
    }
    
        public void save(Banner banner){
        rBanner.save(banner);
        
    }
    public void delete(int id){
    rBanner.deleteById(id);
    }
    
    public boolean existsById(int id){
    return rBanner.existsById(id);
    
    }
    public boolean existsByNombre(String nombre){
        return rBanner.existsByNombre(nombre);
    }
    

}
