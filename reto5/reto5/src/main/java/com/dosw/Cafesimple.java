package com.dosw;

public class Cafesimple implements Cafe {
    private final double precioBase;

    public Cafesimple() {
        this.precioBase = 2000.0;
    }

    @Override
    public String descripcion() {
        return "Café base";
    }

    @Override
    public double obtenerPrecio() {
        return precioBase;
    }
}