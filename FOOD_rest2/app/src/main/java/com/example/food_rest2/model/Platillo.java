package com.example.food_rest2.model;

import java.util.List;

public class Platillo {

    private Integer id;
    private String nombre;
    private List<Platillo> platillos;

    public Platillo() {
    }

    public Platillo(Integer id, String nombre, List<Platillo> platillos) {
        this.id = id;
        this.nombre = nombre;
        this.platillos = platillos;
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

    public List<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }
}
