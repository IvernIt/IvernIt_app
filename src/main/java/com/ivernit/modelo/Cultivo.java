/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import com.ivernit.dao.DAOParametros;
import com.ivernit.dao.DAOVegetal;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Gautarra
 */
public class Cultivo {

    private int id;
    private Date fechaDeInicio;
    private ArrayList<Vegetal> vegetales;
    DAOVegetal DaoVegetal;
    
    public Cultivo(int id, Connection conexion){               
        DaoVegetal = new DAOVegetal(conexion); 
    }


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
