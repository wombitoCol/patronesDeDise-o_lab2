package com.example.demo;

public class Ingredientes {
    private int id;
    private String nombre;
    private int precio;
    private TipoIngrediente tipo;
    
    public enum TipoIngrediente {
        PAN, CARNE, QUESO, VEGETAL, SALSA, OTRO
    }
    
    public Ingredientes(int id, String nombre, int precio, TipoIngrediente tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    
    public TipoIngrediente getTipo() { return tipo; }
    public void setTipo(TipoIngrediente tipo) { this.tipo = tipo; }
    
    @Override
    public String toString() {
        return String.format("%s ($%,d)", nombre, precio);
    }
}
