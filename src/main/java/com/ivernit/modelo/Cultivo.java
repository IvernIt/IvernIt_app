/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gautarra
 */
public class Cultivo {

    private int id;
    private Date fechaDeInicio;
    private ArrayList<Vegetal> vegetales;
    private ArrayList<Parametros> parametros;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }
    public ArrayList<Vegetal> getVegetales() {
        return vegetales;
    }

    public void setVegetales(ArrayList<Vegetal> vegetales) {
        this.vegetales = vegetales;
    }

    public ArrayList<Parametros> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Parametros> parametros) {
        this.parametros = parametros;
    }

    public Vegetal getUltimoVegetal() {
        Vegetal ultimo = null;
        for (Vegetal veg : vegetales) {
            if (ultimo != null) {
                if (ultimo.getEstado().getId() < veg.getEstado().getId()) {
                    ultimo = veg;
                }
            } else {
                ultimo = veg;
            }
        }
        return ultimo;
    }

}
