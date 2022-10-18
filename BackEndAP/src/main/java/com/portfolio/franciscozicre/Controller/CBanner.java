/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Controller;

import com.portfolio.franciscozicre.Dto.dtoBanner;
import com.portfolio.franciscozicre.Entity.Banner;
import com.portfolio.franciscozicre.Security.Controller.Mensaje;
import com.portfolio.franciscozicre.Service.SBanner;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PCMR
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/banner")
    

public class CBanner {
    @Autowired
    SBanner sBanner;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = sBanner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id")int id){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = sBanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
       @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBanner dtobanner){
        if(StringUtils.isBlank(dtobanner.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sBanner.existsByNombre(dtobanner.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = new Banner(
                dtobanner.getNombre()
            );
        sBanner.save(banner);
        return new ResponseEntity(new Mensaje("Entrada creada"), HttpStatus.OK);
                
    }
    
         @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("ID no existe"), HttpStatus.NOT_FOUND);
        }
  
        
        if(sBanner.existsByNombre(dtobanner.getNombre()) && sBanner.getByNombre(dtobanner.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtobanner.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
       
        Banner banner = sBanner.getOne(id).get();
        
        banner.setNombre(dtobanner.getNombre());
        banner.setBgi(dtobanner.getBgi());
        
        sBanner.save(banner);
        
        return new ResponseEntity(new Mensaje("Entrada Banner actualizada"), HttpStatus.OK);
    }
        
    }
