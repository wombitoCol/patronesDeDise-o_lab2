package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class HamburguesaBuilder {
    private List<Ingredientes> ingrediente;
    
    public HamburguesaBuilder() {
        this.ingrediente = new ArrayList<>();
    }
    
    public HamburguesaBuilder agregarPan(Ingredientes pan) {
        this.ingrediente.add(pan);
        return this;
    }
    
    public HamburguesaBuilder agregarCarne(Ingredientes carne) {
        this.ingrediente.add(carne);
        return this;
    }
    
    public HamburguesaBuilder agregarQueso(Ingredientes queso) {
        this.ingrediente.add(queso);
        return this;
    }
    
    public HamburguesaBuilder agregarVegetal(Ingredientes vegetal) {
        this.ingrediente.add(vegetal);
        return this;
    }
    
    public HamburguesaBuilder agregarSalsa(Ingredientes salsa) {
        this.ingrediente.add(salsa);
        return this;
    }
    
    public HamburguesaBuilder agregarIngrediente(Ingredientes ingrediente) {
        this.ingrediente.add(ingrediente);
        return this;
    }
    
    public Hamburguesa build() {
        Hamburguesa hamburguesa = new Hamburguesa();
        this.ingrediente.forEach(hamburguesa::agregarIngrediente);
        return hamburguesa;
    }
    
    public void reset() {
        this.ingrediente.clear();
    }
}
