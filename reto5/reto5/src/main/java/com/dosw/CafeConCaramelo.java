package com.dosw;

public class CafeConCaramelo extends Cafepersonalizado {
    private static final double PRECIO = 1200.0;

    public CafeConCaramelo(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String descripcion() {
        return cafeDecorado.descripcion() + " + Caramelo";
    }

    @Override
    public double obtenerPrecio() {
        return cafeDecorado.obtenerPrecio() + PRECIO;
    }
}