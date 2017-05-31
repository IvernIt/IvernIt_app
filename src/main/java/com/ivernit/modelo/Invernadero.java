/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import com.ivernit.dao.DAOCultivo;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Gautarra
 */
public class Invernadero {

    private String nombre;
    private int id;
    private ArrayList<Cultivo> cultivo;
    private DAOCultivo DaoCultivo;

    public Invernadero() {

    }

    public Invernadero(Connection conexion) {
        DaoCultivo = new DAOCultivo(conexion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cultivo> getCultivo() {
        if (cultivo == null && DaoCultivo != null) {
            cultivo = DaoCultivo.getCultivoPorInvernadero(id);
        }
        return cultivo;
    }

    public void setCultivo(ArrayList<Cultivo> cultivo) {
        this.cultivo = cultivo;
    }

}
