package com.dosw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("   CAFETERÍA CREATIVA - Sistema de Pedidos");
        System.out.println("==================================================");
        System.out.println();

        System.out.println("Seleccione el modo:");
        System.out.println("1. Ver ejemplos automáticos");
        System.out.println("2. Personalizar mi propio café");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();

        if (opcion == 1) {
            ejemploCafeSimple();
            ejemploCafePersonalizado();
            ejemploConStreams();
        } else if (opcion == 2) {
            modoInteractivo(scanner);
        } else {
            System.out.println("Opción inválida");
        }

        scanner.close();
    }

    private static void modoInteractivo(Scanner scanner) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("        PERSONALIZA TU CAFÉ");
        System.out.println("==================================================");
        System.out.println();

        System.out.print("¿Cuántos cafés desea pedir? ");
        int numCafes = scanner.nextInt();

        List<Cafe> pedido = new ArrayList<>();

        for (int i = 1; i <= numCafes; i++) {
            System.out.println();
            System.out.println("--- CAFÉ #" + i + " ---");
            Cafe cafe = personalizarCafe(scanner, i);
            pedido.add(cafe);

            System.out.println();
            System.out.println("Café #" + i + " creado:");
            imprimirCafe(cafe);
        }

        // Resumen del pedido
        System.out.println();
        System.out.println("==================================================");
        System.out.println("        RESUMEN DEL PEDIDO");
        System.out.println("==================================================");

        double totalGeneral = 0;
        for (int i = 0; i < pedido.size(); i++) {
            Cafe cafe = pedido.get(i);
            System.out.println();
            System.out.println("Café #" + (i + 1) + ":");
            System.out.println("  " + cafe.descripcion());
            System.out.println("  Precio: $" + cafe.obtenerPrecio());
            totalGeneral += cafe.obtenerPrecio();
        }

        System.out.println();
        System.out.println("==================================================");
        System.out.println("TOTAL A PAGAR: $" + totalGeneral);
        System.out.println("==================================================");
        System.out.println("¡Gracias por su compra!");
    }

    private static Cafe personalizarCafe(Scanner scanner, int numCafe) {
        Cafe cafe = new Cafesimple();
        System.out.println("Café base: $" + cafe.obtenerPrecio());
        System.out.println();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Toppings disponibles:");
            System.out.println("1. Leche (+$1000)");
            System.out.println("2. Chocolate (+$1500)");
            System.out.println("3. Caramelo (+$1200)");
            System.out.println("4. Crema Batida (+$2000)");
            System.out.println("5. Menta (+$1300)");
            System.out.println("0. Finalizar este café");
            System.out.print("Seleccione topping: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cafe = new CafeConLeche(cafe);
                    System.out.println("✓ Leche agregada");
                    break;
                case 2:
                    cafe = new CafeLate(cafe);
                    System.out.println("✓ Chocolate agregado");
                    break;
                case 3:
                    cafe = new CafeConCaramelo(cafe);
                    System.out.println("✓ Caramelo agregado");
                    break;
                case 4:
                    cafe = new CafeConCremaBatida(cafe);
                    System.out.println("✓ Crema Batida agregada");
                    break;
                case 5:
                    cafe = new CafeConMenta(cafe);
                    System.out.println("✓ Menta agregada");
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("✗ Opción inválida");
            }

            if (opcion != 0) {
                System.out.println("Precio actual: $" + cafe.obtenerPrecio());
                System.out.println();
            }
        }

        return cafe;
    }

    private static void ejemploCafeSimple() {
        System.out.println("EJEMPLO 1: Café Simple");
        System.out.println("==================================================");

        Cafe cafe = new Cafesimple();
        imprimirCafe(cafe);
        System.out.println();
    }

    private static void ejemploCafePersonalizado() {
        System.out.println("EJEMPLO 2: Café Personalizado");
        System.out.println("==================================================");

        Cafe miCafe = new Cafesimple();
        System.out.println("Paso 1 - Café base: " + miCafe.descripcion() + " - $" + miCafe.obtenerPrecio());

        miCafe = new CafeConLeche(miCafe);
        System.out.println("Paso 2 - + Leche: " + miCafe.descripcion() + " - $" + miCafe.obtenerPrecio());

        miCafe = new CafeLate(miCafe);
        System.out.println("Paso 3 - + Chocolate: " + miCafe.descripcion() + " - $" + miCafe.obtenerPrecio());

        miCafe = new CafeConCaramelo(miCafe);
        System.out.println("Paso 4 - + Caramelo: " + miCafe.descripcion() + " - $" + miCafe.obtenerPrecio());

        System.out.println();
        System.out.println("--- RECIBO FINAL ---");
        imprimirCafe(miCafe);
        System.out.println();
    }

    private static void ejemploConStreams() {
        System.out.println("EJEMPLO 3: Uso de Streams");
        System.out.println("==================================================");

        Cafe cafe1 = new CafeConLeche(new Cafesimple());
        Cafe cafe2 = new CafeLate(new CafeConLeche(new Cafesimple()));
        Cafe cafe3 = new CafeConCaramelo(new CafeLate(new CafeConLeche(new Cafesimple())));

        List<Cafe> pedido = Arrays.asList(cafe1, cafe2, cafe3);

        System.out.println("Cafés en el pedido:");
        for (Cafe cafe : pedido) {
            System.out.println("  - " + cafe.descripcion() + " ($" + cafe.obtenerPrecio() + ")");
        }

        double total = 0;
        for (Cafe cafe : pedido) {
            total += cafe.obtenerPrecio();
        }

        System.out.println();
        System.out.println("Total del pedido: $" + total);

        int cafesCaros = 0;
        for (Cafe cafe : pedido) {
            if (cafe.obtenerPrecio() > 5000) {
                cafesCaros++;
            }
        }

        System.out.println("Cafés con precio mayor a $5000: " + cafesCaros);
        System.out.println();
    }

    private static void imprimirCafe(Cafe cafe) {
        System.out.println("Descripción: " + cafe.descripcion());
        System.out.println("Precio Total: $" + cafe.obtenerPrecio());
    }
}