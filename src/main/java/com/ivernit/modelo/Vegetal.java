/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.modelo;

import com.ivernit.dao.DAOEstadoCrecimiento;
import com.ivernit.dao.DAOParametros;
import java.sql.Connection;

/**
 *
 * @author Gautarra
 */
public class Vegetal {

    private int id;
    private int idCultivo;
    private String nombre;
    private EstadoCrecimiento estado;
    private DAOEstadoCrecimiento DaoEstadoCrecimiento;
    private Parametros parametro;
    private DAOParametros DaoParametros;

    public Vegetal() {

    }

    public Vegetal(int id, int idCultivo, Connection conexion) {
        this.id = id;
        this.DaoEstadoCrecimiento = new DAOEstadoCrecimiento(conexion);
        this.DaoParametros = new DAOParametros(conexion);
    }

    public Parametros getParametro() {
        if (parametro == null && DaoParametros != null) {
            parametro = DaoParametros.getParametrosPorCultivo(idCultivo, id);
        }
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

    public EstadoCrecimiento getEstado() {
        if (estado == null && DaoEstadoCrecimiento != null) {
            estado = DaoEstadoCrecimiento.getEstadoCrecimientoPorIdVegetal(id);
        }
        return estado;
    }

    public void setEstado(EstadoCrecimiento estado) {
        this.estado = estado;
    }

}
