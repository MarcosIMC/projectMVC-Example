/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 *
 * @author Markensi
 */
public class courses {
    String nombre;
    String[] asignaturas;
    String[] profesores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String[] getProfesores() {
        return profesores;
    }

    public void setProfesores(String[] profesores) {
        this.profesores = profesores;
    }
    
    
}
