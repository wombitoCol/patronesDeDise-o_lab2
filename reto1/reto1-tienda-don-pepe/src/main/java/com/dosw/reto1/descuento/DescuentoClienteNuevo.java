package com.dosw.reto1.descuento;

public class DescuentoClienteNuevo implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.05; // 5% de descuento
    }

    @Override
    public String getTipoCliente() {
        return "Nuevo";
    }

    @Override
    public double getPorcentaje() {
        return 5.0;
    }
}