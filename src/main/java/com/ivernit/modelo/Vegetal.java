package com.ivernit.modelo;

import com.ivernit.dao.DAOEstadoCrecimiento;
import com.ivernit.dao.DAOParametros;

/**
 * Se relaciona un vegetal con su estado de crecimiento y parámetros
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

    public Vegetal(int id, int idCultivo) {
        this.id = id;
        this.idCultivo = idCultivo;
        this.DaoEstadoCrecimiento = new DAOEstadoCrecimiento();
        this.DaoParametros = new DAOParametros();
    }

    public Parametros getParametros() {
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
