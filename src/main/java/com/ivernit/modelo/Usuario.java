package com.ivernit.modelo;

import com.ivernit.dao.DAOInvernadero;
import java.util.ArrayList;

/**
 * Se relaciona un usuario que se ha logeado con sus invernaderos
 * @author Pablo
 */
public class Usuario {

    private static Usuario usuarioActivo;
    private int id;
    private String nombre, contraseña;
    private boolean premium;
    private ArrayList<Invernadero> invernaderos;
    private DAOInvernadero daoInvernadero;
    public Usuario() {
        invernaderos = new ArrayList<>();
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
        daoInvernadero = new DAOInvernadero();
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
        if (invernaderos == null && daoInvernadero != null) {
            invernaderos = daoInvernadero.getInvernaderoPorUsr(nombre);
        }
        return invernaderos;
    }

    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Usuario usuarioActivo) {
        Usuario.usuarioActivo = usuarioActivo;
    }

}
