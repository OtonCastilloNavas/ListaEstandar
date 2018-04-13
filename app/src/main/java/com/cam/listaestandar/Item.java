package com.cam.listaestandar;

public class Item {
    public String nombre;
    public String apellido;
    public String anio;

    public Item(String nombre, String apellido, String anio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
