/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Repository;

import com.portfolio.franciscozicre.Entity.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author PCMR
 */
@Repository
public interface RBanner extends JpaRepository<Banner, Integer>{
    
    public Optional<Banner> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}