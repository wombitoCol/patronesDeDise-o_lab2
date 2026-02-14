package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Hamburguesa {
    private List<Ingredientes> ingredientes;
    
    public Hamburguesa() {
        this.ingredientes = new ArrayList<>();
    }
    
    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }
    
    public void agregarIngrediente(Ingredientes ingrediente) {
        this.ingredientes.add(ingrediente);
    }
    
    public int calcularPrecioTotal() {
        return ingredientes.stream()
                .mapToInt(Ingredientes::getPrecio)
                .sum();
    }
}
