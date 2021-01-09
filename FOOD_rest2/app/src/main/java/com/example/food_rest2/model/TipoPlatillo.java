package com.example.food_rest2.model;

public class TipoPlatillo {

    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String fotoPlatillo;
    private TipoPlatillo tipoPlatillo;

    public TipoPlatillo() {
    }

    public TipoPlatillo(Integer id, String nombre, String descripcion, double precio, String fotoPlatillo, TipoPlatillo tipoPlatillo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fotoPlatillo = fotoPlatillo;
        this.tipoPlatillo = tipoPlatillo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFotoPlatillo() {
        return fotoPlatillo;
    }

    public void setFotoPlatillo(String fotoPlatillo) {
        this.fotoPlatillo = fotoPlatillo;
    }

    public TipoPlatillo getTipoPlatillo() {
        return tipoPlatillo;
    }

    public void setTipoPlatillo(TipoPlatillo tipoPlatillo) {
        this.tipoPlatillo = tipoPlatillo;
    }
}
