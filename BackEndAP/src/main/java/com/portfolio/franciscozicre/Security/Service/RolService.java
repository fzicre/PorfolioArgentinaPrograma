/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Security.Service;

import com.portfolio.franciscozicre.Security.Entity.Rol;
import com.portfolio.franciscozicre.Security.Enums.RolNombre;
import com.portfolio.franciscozicre.Security.Repository.iRolRepository;
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
public class RolService {
    @Autowired
    iRolRepository irolRepository;
            
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
    return irolRepository.findByRolNombre (rolNombre);
    }
    public void save(Rol rol){
            irolRepository.save(rol);
    }
    
}
