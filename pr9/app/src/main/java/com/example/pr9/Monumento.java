package com.example.pr9;

public class Monumento {
    public String id;
    public String nombre;
    public String ciudad;
    public String descripcion;
    public String fecha;
    public String precio;
    public String latitud;
    public String moneda;
    public String longitud;
    public String visitable;
    public String video;
    public String imagen;

    public Monumento() {
        this.id = "";
        this.nombre = "";
        this.ciudad = "";
        this.descripcion = "";
        this.fecha = "";
        this.precio = "";
        this.latitud = "";
        this.moneda = "";
        this.longitud = "";
        this.visitable = "";
        this.video = "";
        this.imagen = "";
    }
    public Monumento(String id, String nombre, String ubicacion, String descripcion, String fecha, String precio, String latitud, String moneda, String longitud, String visitable, String video, String image) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ubicacion;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.latitud = latitud;
        this.moneda = moneda;
        this.longitud = longitud;
        this.visitable = visitable;
        this.video = video;
        this.imagen = imagen;
    }
}