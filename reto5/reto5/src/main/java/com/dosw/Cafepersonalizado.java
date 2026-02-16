package com.dosw;

public abstract class Cafepersonalizado implements Cafe {
    protected Cafe cafeDecorado;

    public Cafepersonalizado(Cafe cafe) {
        this.cafeDecorado = cafe;
    }

    @Override
    public String descripcion() {
        return cafeDecorado.descripcion();
    }

    @Override
    public double obtenerPrecio() {
        return cafeDecorado.obtenerPrecio();
    }
}