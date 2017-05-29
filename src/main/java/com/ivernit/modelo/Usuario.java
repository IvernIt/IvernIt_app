/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Usuario {

    private int id;
    private String nombre;
    private boolean premium;
    private ArrayList<Invernadero> invernaderos;

    public Usuario() {
        invernaderos = new ArrayList<>();
    }

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

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setInvernaderos(ArrayList<Invernadero> invernaderos) {
        this.invernaderos = invernaderos;
    }

    public ArrayList<Invernadero> getInvernaderos() {
        return invernaderos;
    }

}
