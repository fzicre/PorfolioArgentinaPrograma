/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Controller;

import com.portfolio.franciscozicre.Dto.dtoSkills;
import com.portfolio.franciscozicre.Entity.skills;
import com.portfolio.franciscozicre.Security.Controller.Mensaje;
import com.portfolio.franciscozicre.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = {"https://argentina-programa-portf-de743.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://argentina-programa-portf-de743.web.app/")
@RequestMapping("/skill")
public class CSkills {

    @Autowired
    SSkills sSkills;

    @GetMapping("/lista")
    public ResponseEntity<List<skills>> list() {
        List<skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        skills Skills = sSkills.getOne(id).get();
        return new ResponseEntity(Skills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills) {
        if (StringUtils.isBlank(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo nombre esta en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (sSkills.existsByNombre(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        skills Skills = new skills(dtoskills.getNombre(), dtoskills.getPorcentaje());
        sSkills.save(Skills);

        return new ResponseEntity(new Mensaje("Experiencia cargada con exito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        if (sSkills.existsByNombre(dtoskills.getNombre()) && sSkills.getByNombre(dtoskills.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo nombre esta en blanco"), HttpStatus.BAD_REQUEST);
        }

        skills Skills = sSkills.getOne(id).get();
        Skills.setNombre(dtoskills.getNombre());
        Skills.setPorcentaje(dtoskills.getPorcentaje());

        sSkills.save(Skills);
        return new ResponseEntity(new Mensaje("Se actualizó el skill exitosamente"), HttpStatus.OK);

    }

}
