/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import com.ivernit.dao.DAOEstadoCrecimiento;
import java.sql.Connection;

/**
 *
 * @author Gautarra
 */
public class Vegetal {
    private int id;
    private String nombre;
    private EstadoCrecimiento estado;
    private Parametros parametro;
    DAOEstadoCrecimiento DaoEstadoCrecimiento;

    public Vegetal(int id, Connection conexion){
        DaoEstadoCrecimiento = new DAOEstadoCrecimiento(conexion);
    }
  
    public Parametros getParametro() {
        return parametro;
    }

    public void setParametro(Parametros parametro) {
        this.parametro = parametro;
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
  
    public EstadoCrecimiento getEstado(int idVegetal) {
        estado = DaoEstadoCrecimiento.getEstadoCrecimientoPorIdVegetal(idVegetal);
        return estado;
    }

    public void setEstado(EstadoCrecimiento estado) {
        this.estado = estado;
    }
    
    
    
}
