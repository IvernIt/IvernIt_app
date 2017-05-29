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
public class Vegetal {
    private int id;
    private String nombre;
    private ArrayList<EstadoCrecimiento> estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<EstadoCrecimiento> getEstado() {
        return estado;
    }

    public void setEstado(ArrayList<EstadoCrecimiento> estado) {
        this.estado = estado;
    }
    
    
    
}
