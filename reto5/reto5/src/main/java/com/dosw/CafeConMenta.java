package com.dosw;

public class CafeConMenta extends Cafepersonalizado {
    private static final double PRECIO = 1300.0;

    public CafeConMenta(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String descripcion() {
        return cafeDecorado.descripcion() + " + Menta";
    }

    @Override
    public double obtenerPrecio() {
        return cafeDecorado.obtenerPrecio() + PRECIO;
    }
}