/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.franciscozicre.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author PCMR
 */
public class dtoBanner {

    private String bgi;
    @NotBlank
    private String nombre;

    public dtoBanner() {
    }

    public dtoBanner(String nombre, String bgi) {

        this.nombre = nombre;
        this.bgi = bgi;

    }

     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getBgi() {
        return bgi;
    }

    public void setImg(String bgi) {
        this.bgi = bgi;
    }

}
