package com.dosw;

public class CafeLate extends Cafepersonalizado {
    private static final double PRECIO = 1500.0;

    public CafeLate(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String descripcion() {
        return cafeDecorado.descripcion() + " + Chocolate";
    }

    @Override
    public double obtenerPrecio() {
        return cafeDecorado.obtenerPrecio() + PRECIO;
    }
}