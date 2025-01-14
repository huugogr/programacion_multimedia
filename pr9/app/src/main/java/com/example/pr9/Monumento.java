package com.example.pr9;

public class Monumento {
    private String id;
    private String nombre;
    private String ciudad;
    private String descripcion;
    private String fecha;
    private String precio;
    private String latitud;
    private String moneda;
    private String longitud;
    private String visitable;
    private String video;
    private String image;

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
        this.image = "";
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
        this.image = image;
    }
}