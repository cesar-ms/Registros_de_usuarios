/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Julio
 */
public class Usuario {

    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apPaterno;
    private final SimpleStringProperty apMaterno;
    private final SimpleStringProperty edad;
    private final SimpleStringProperty correo;

    public Usuario(String nombre, String apPaterno, String apMaterno, String edad, String correo) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apPaterno = new SimpleStringProperty(apPaterno);
        this.apMaterno = new SimpleStringProperty(apMaterno);
        this.edad = new SimpleStringProperty(edad);
        this.correo = new SimpleStringProperty(correo);
    }

    public String getNombre() {
        return this.nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApPaterno() {
        return this.apPaterno.get();
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno.set(apPaterno);
    }

    public String getApMaterno() {
        return this.apMaterno.get();
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno.set(apMaterno);
    }

    public String getEdad() {
        return this.edad.get();
    }

    public void setEdad(String edad) {
        this.edad.set(edad);
    }

    public String getCorreo() {
        return this.correo.get();
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }
}
