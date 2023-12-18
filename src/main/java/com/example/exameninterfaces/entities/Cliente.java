package com.example.exameninterfaces.entities;

public class Cliente {
    private Integer id;
    private String nombre;
    private String correo;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cliente(Integer id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Cliente() {
        this.id = 0;
        this.nombre = "Vacio";
        this.correo = "Vacio";
    }
}
