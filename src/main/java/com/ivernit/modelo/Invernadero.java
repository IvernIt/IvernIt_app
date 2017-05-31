/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import com.ivernit.dao.DAOCultivo;
import com.ivernit.dao.DAOParametros;
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
    private ArrayList<Parametros> parametros;
    private DAOCultivo daoCultivo;
    private DAOParametros daoParametros;

    public Invernadero(int id) {
        this.id = id;
        daoCultivo = new DAOCultivo();
        daoParametros = new DAOParametros();
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
        if (cultivo == null && daoCultivo != null) {
            cultivo = daoCultivo.getCultivoPorInvernadero(id);
        }
        return cultivo;
    }

    public void setCultivo(ArrayList<Cultivo> cultivo) {
        this.cultivo = cultivo;
    }

    public ArrayList<Parametros> getParametros() {
        if (parametros == null && daoParametros != null) {
            parametros = daoParametros.getParametrosPorInverndero(id);
        }
        return parametros;
    }

}
