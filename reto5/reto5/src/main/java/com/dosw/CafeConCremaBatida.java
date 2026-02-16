package com.dosw;

public class CafeConCremaBatida extends Cafepersonalizado {
    private static final double PRECIO = 2000.0;

    public CafeConCremaBatida(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String descripcion() {
        return cafeDecorado.descripcion() + " + Crema Batida";
    }

    @Override
    public double obtenerPrecio() {
        return cafeDecorado.obtenerPrecio() + PRECIO;
    }
}