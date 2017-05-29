/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import java.util.ArrayList;

/**
 *
 * @author Gautarra
 */
public class Cultivo {
    private int id;
    private ArrayList<Vegetal> vegetales;
    private ArrayList<Parametros> parametros;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
}
