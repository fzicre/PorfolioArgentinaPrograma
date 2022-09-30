/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Security.Repository;

import com.portfolio.franciscozicre.Security.Entity.Rol;
import com.portfolio.franciscozicre.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PCMR
 */
@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
