package com.dosw.reto1.modelo;

import com.dosw.reto1.descuento.EstrategiaDescuento;

public class Cliente {
    private EstrategiaDescuento estrategiaDescuento;

    public Cliente(EstrategiaDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }

    public double aplicarDescuento(double subtotal) {
        return estrategiaDescuento.calcularDescuento(subtotal);
    }

    public String getTipo() {
        return estrategiaDescuento.getTipoCliente();
    }

    public double getPorcentajeDescuento() {
        return estrategiaDescuento.getPorcentaje();
    }
}