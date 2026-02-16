package com.dosw.reto1;

import com.dosw.reto1.descuento.DescuentoClienteFrecuente;
import com.dosw.reto1.descuento.DescuentoClienteNuevo;
import com.dosw.reto1.modelo.CarritoCompras;
import com.dosw.reto1.modelo.Cliente;
import com.dosw.reto1.modelo.Producto;

import java.util.Scanner;

public class Reto1TiendaDonPepe {

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bienvenido a la tienda Don Pepe! ===\n");

        // Crear productos disponibles
        Producto camiseta = new Producto("Camiseta", 20000);
        Producto galletas = new Producto("Galletas", 500);
        Producto jugo = new Producto("Jugo Natural", 3000);

        // Seleccionar tipo de cliente
        System.out.println("Tipo de cliente:");
        System.out.println("1. Nuevo (5% descuento)");
        System.out.println("2. Frecuente (10% descuento)");
        System.out.print("Ingrese opción: ");
        int opcionCliente = scanner.nextInt();

        Cliente cliente;
        if (opcionCliente == 1) {
            cliente = new Cliente(new DescuentoClienteNuevo());
        } else {
            cliente = new Cliente(new DescuentoClienteFrecuente());
        }

        System.out.println("\nCliente: " + cliente.getTipo());

        // Mostrar productos disponibles
        System.out.println("\nProductos disponibles:");
        System.out.println("1. Camiseta - $20,000");
        System.out.println("2. Galletas - $500");
        System.out.println("3. Jugo Natural - $3,000");

        // Crear carrito
        CarritoCompras carrito = new CarritoCompras();

        // Ingresar compras
        System.out.println("\nIngrese su compra:");

        System.out.print("¿Cuántas Camisetas? ");
        int cantCamisetas = scanner.nextInt();
        if (cantCamisetas > 0) {
            carrito.agregarProducto(camiseta, cantCamisetas);
        }

        System.out.print("¿Cuántas Galletas? ");
        int cantGalletas = scanner.nextInt();
        if (cantGalletas > 0) {
            carrito.agregarProducto(galletas, cantGalletas);
        }

        System.out.print("¿Cuántos Jugos Naturales? ");
        int cantJugos = scanner.nextInt();
        if (cantJugos > 0) {
            carrito.agregarProducto(jugo, cantJugos);
        }

        // Calcular totales
        double subtotal = carrito.calcularSubtotal();
        double descuento = cliente.aplicarDescuento(subtotal);
        double total = subtotal - descuento;

        // Imprimir recibo
        imprimirRecibo(cliente, carrito, subtotal, descuento, total);

        scanner.close();
    }

    private static void imprimirRecibo(Cliente cliente, CarritoCompras carrito,
                                       double subtotal, double descuento, double total) {
        System.out.println("\n--- RECIBO DE COMPRA ---");
        System.out.println("Cliente: " + cliente.getTipo());
        System.out.println("\nProductos:");

        carrito.getItems().forEach(item -> {
            System.out.printf("  - %s - $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getTotal());
        });

        System.out.printf("\nSubtotal: $%,.0f%n", subtotal);
        System.out.printf("Descuento aplicado: $%,.0f%n", descuento);
        System.out.printf("Total a pagar: $%,.0f%n", total);
        System.out.println("------------------------");
        System.out.println("¡Gracias por su compra!");
    }

    public static void main(String[] args) {
        ejecutar();
    }
}