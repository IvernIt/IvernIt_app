package com.ivernit.modelo;

import com.ivernit.dao.DAOCultivo;
import com.ivernit.dao.DAOParametros;
import java.util.ArrayList;

/**
 * Relaciona un invernadero con todos sus cultivos
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

    public Invernadero(String nombre) {
        this.nombre = nombre;
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
