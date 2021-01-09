package com.example.food_spring.Utils;

public class Apis {

    public static final String URL_001="http://localhost:8091/api/v1/platillos";

    public static PlatilloService getDesayunoService(){
        return Cliente.getCliente(URL_001).create(PlatilloService.class);
    }
}
