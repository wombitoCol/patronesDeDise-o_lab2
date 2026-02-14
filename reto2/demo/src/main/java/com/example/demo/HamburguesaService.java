package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HamburguesaService {
    private List<Ingredientes> catalogoIngredientes;
    private HamburguesaBuilder builder;
    
    public HamburguesaService() {
        this.builder = new HamburguesaBuilder();
        inicializarCatalogo();
    }
    
private void inicializarCatalogo() {
    catalogoIngredientes = new ArrayList<>();
    catalogoIngredientes.add(new Ingredientes(1, "Pan Artesanal", 3000, Ingredientes.TipoIngrediente.PAN));
    catalogoIngredientes.add(new Ingredientes(2, "Pan Brioche", 3500, Ingredientes.TipoIngrediente.PAN));
    catalogoIngredientes.add(new Ingredientes(3, "Carne de Res 200g", 10000, Ingredientes.TipoIngrediente.CARNE));
    catalogoIngredientes.add(new Ingredientes(4, "Carne de Pollo", 8000, Ingredientes.TipoIngrediente.CARNE));
    catalogoIngredientes.add(new Ingredientes(5, "Queso Cheddar", 5000, Ingredientes.TipoIngrediente.QUESO));
    catalogoIngredientes.add(new Ingredientes(6, "Queso Mozzarella", 4500, Ingredientes.TipoIngrediente.QUESO));
    catalogoIngredientes.add(new Ingredientes(7, "Lechuga", 1000, Ingredientes.TipoIngrediente.VEGETAL));
    catalogoIngredientes.add(new Ingredientes(8, "Tomate", 1500, Ingredientes.TipoIngrediente.VEGETAL));
    catalogoIngredientes.add(new Ingredientes(9, "Cebolla", 1000, Ingredientes.TipoIngrediente.VEGETAL));
    catalogoIngredientes.add(new Ingredientes(10, "Tocino", 4000, Ingredientes.TipoIngrediente.OTRO));
    catalogoIngredientes.add(new Ingredientes(11, "Salsa de Tomate", 500, Ingredientes.TipoIngrediente.SALSA));
    catalogoIngredientes.add(new Ingredientes(12, "Mayonesa", 500, Ingredientes.TipoIngrediente.SALSA));
    catalogoIngredientes.add(new Ingredientes(13, "Mostaza", 500, Ingredientes.TipoIngrediente.SALSA));
    catalogoIngredientes.add(new Ingredientes(14, "Salsa BBQ", 800, Ingredientes.TipoIngrediente.SALSA));
    catalogoIngredientes.add(new Ingredientes(15, "Huevo", 2000, Ingredientes.TipoIngrediente.OTRO));
    }
    
    public List<Ingredientes> getCatalogoIngredientes() {
        return catalogoIngredientes;
    }
    
    public Hamburguesa crearHamburguesaPersonalizada(Scanner scanner) {
        builder.reset();
        List<Integer> idsSeleccionados = new ArrayList<>();
        
        System.out.println("Construye tu hamburguesa paso a paso:");
        System.out.println("(Ingresa los números de los ingredientes separados por coma o espacio)");
        System.out.println("Ejemplo: 1,3,5,10,11");
        System.out.print("Tus ingredientes: ");
        
        String input = scanner.nextLine();
        String[] partes = input.split("[,\\s]+");
        
        for (String parte : partes) {
            if (!parte.trim().isEmpty()) {
                int id = Integer.parseInt(parte.trim());
                idsSeleccionados.add(id);
            }
        }
        
        List<Ingredientes> seleccionados = catalogoIngredientes.stream()
                .filter(ing -> idsSeleccionados.contains(ing.getId()))
                .collect(Collectors.toList());
        
        seleccionados.forEach(builder::agregarIngrediente);
        
        return builder.build();
    }
}