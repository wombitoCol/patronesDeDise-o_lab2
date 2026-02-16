package com.example.demo;
import java.util.Scanner;

public class Challenge2{
    public static void ejecutar() {
        HamburguesaService service = new HamburguesaService();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CHEF DE 5 ESTRELLAS ===");
        System.out.println("Bienvenido a la Hamburguesería Personalizada\n");
        
        System.out.println("Menú de Ingredientes Disponibles:");
        service.getCatalogoIngredientes().forEach(ing -> 
            System.out.printf("%d. %s ($%,d)%n", 
                ((Ingredientes)ing).getId(), ((Ingredientes)ing).getNombre(), ((Ingredientes)ing).getPrecio())
        );
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DOTSU COMPANY");
        System.out.println("=".repeat(50) + "\n");
        
        Hamburguesa hamburguesa = service.crearHamburguesaPersonalizada(scanner);
        
        System.out.println("\n" + "-".repeat(50));
        System.out.println("--- HAMBURGUESA PERSONALIZADA ---");
        System.out.println("Ingredientes seleccionados: " + 
            String.join(", ", hamburguesa.getIngredientes().stream()
                .map(ing -> ing.getNombre())
                .toList()));
        System.out.printf("Precio total: $%,d%n", hamburguesa.calcularPrecioTotal());
        System.out.println("-".repeat(50));
        System.out.println("¡Disfrute su hamburguesa!");
        
        scanner.close();
    }
}
