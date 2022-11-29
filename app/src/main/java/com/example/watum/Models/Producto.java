package com.example.watum.Models;

public class Producto {
    private String id;
    private String estado;
    private String imagen;
    private String fecha;

    public Producto(String id, String estado, String imagen, String fecha) {
        this.id = id;
        this.estado = estado;
        this.imagen = imagen;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
