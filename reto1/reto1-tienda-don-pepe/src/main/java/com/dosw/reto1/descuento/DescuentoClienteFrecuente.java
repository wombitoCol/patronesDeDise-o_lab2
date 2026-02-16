package com.dosw.reto1.descuento;

public class DescuentoClienteFrecuente implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.10; // 10% de descuento
    }

    @Override
    public String getTipoCliente() {
        return "Frecuente";
    }

    @Override
    public double getPorcentaje() {
        return 10.0;
    }
}