/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Repository;

import com.portfolio.franciscozicre.Entity.skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PCMR
 */
public interface RSkills extends JpaRepository<skills, Integer>{ 
    Optional<skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
    
}
