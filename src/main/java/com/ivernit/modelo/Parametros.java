/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

/**
 *
 * @author Gautarra
 */
public class Parametros {
    
    private int id;
    private double agua;
    private double horasLuz;
    private double temperatura;
    private String tipoTierra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getHorasLuz() {
        return horasLuz;
    }

    public void setHorasLuz(double horasLuz) {
        this.horasLuz = horasLuz;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipoTierra() {
        return tipoTierra;
    }

    public void setTipoTierra(String tipoTierra) {
        this.tipoTierra = tipoTierra;
    }
 
    
    
}
