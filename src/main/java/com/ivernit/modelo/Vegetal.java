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
public class Vegetal {
    private int id, parametro;
    private String nombre;
    private EstadoCrecimiento estado;
    
    DAOEstadoCrecimiento DaoEstadoCrecimiento;
    
    public Vegetal(int id, Connection conexion){
        DaoEstadoCrecimiento = new DAOEstadoCrecimiento(conexion);
    }

    public int getParametro() {
        return parametro;
    }

    public void setParametro(int parametro) {
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
