package com.dosw;

public class CafeConLeche extends Cafepersonalizado {
    private static final double PRECIO = 1000.0;

    public CafeConLeche(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String descripcion() {
        return cafeDecorado.descripcion() + " + Leche";
    }

    @Override
    public double obtenerPrecio() {
        return cafeDecorado.obtenerPrecio() + PRECIO;
    }
}