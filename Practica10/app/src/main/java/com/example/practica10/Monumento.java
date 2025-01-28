package com.example.practica10;

public class Monumento {
    public String id;
    public String nombre;
    public String descripcion;
    public String fecha;
    public String latitud;
    public String longitud;
    public String ciudad;
    public String visitable;
    public String precio;
    public String moneda;
    public String video;
    public String imagen;

    public Monumento() {
    }

    public Monumento(String id, String nombre, String descripcion, String fecha, String latitud, String longitud,
                     String ciudad, String visitable, String precio, String moneda, String video, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ciudad = ciudad;
        this.visitable = visitable;
        this.precio = precio;
        this.moneda = moneda;
        this.video = video;
        this.imagen = imagen;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getVisitable() {
        return visitable;
    }

    public void setVisitable(String visitable) {
        this.visitable = visitable;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
