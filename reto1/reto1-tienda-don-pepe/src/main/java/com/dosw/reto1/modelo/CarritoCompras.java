package com.dosw.reto1.modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private List<ItemCarrito> items;

    public CarritoCompras() {
        this.items = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
        System.out.println(producto.getNombre() + " " + cantidad + " unidades agregado al carrito.");
    }

    public double calcularSubtotal() {
        return items.stream()
                .mapToDouble(item -> item.getProducto().getPrecioUnitario() * item.getCantidad())
                .sum();
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    // Clase interna para manejar producto + cantidad
    public static class ItemCarrito {
        private Producto producto;
        private int cantidad;

        public ItemCarrito(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public Producto getProducto() {
            return producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getTotal() {
            return producto.getPrecioUnitario() * cantidad;
        }
    }
}