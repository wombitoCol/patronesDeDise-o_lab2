package com.dosw.reto1.descuento;

public interface EstrategiaDescuento {
    double calcularDescuento(double subtotal);
    String getTipoCliente();
    double getPorcentaje();
}