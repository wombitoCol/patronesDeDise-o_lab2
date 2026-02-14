# RETO #2: El chef de 5 estrellas

## Patrón de Diseño
- **Categoría:** Creacional
- **Patrón Utilizado:** Builder

## Justificación
El patrón Builder es ideal para este caso porque:
- Permite construir objetos complejos (hamburguesas) paso a paso
- Facilita la creación de diferentes combinaciones de ingredientes
- El proceso de construcción es controlado y claro
- Separa la construcción del objeto de su representación final

## Cómo lo aplico
1. **Producto:** `Hamburguesa` - el objeto final que se construye
2. **Builder:** `HamburguesaBuilder` - construye la hamburguesa paso a paso con métodos como `agregarPan()`, `agregarCarne()`, `agregarQueso()`, etc.
3. **Director:** `HamburguesaService` - guía el proceso de construcción según la selección del usuario
4. **Cliente:** `Challenge2` - solicita la creación de hamburguesas personalizadas

## Principios SOLID aplicados
- **S:** Cada clase tiene una única responsabilidad (Ingredientes solo representa datos, Hamburguesa solo almacena, Builder solo construye)
- **O:** Podemos agregar nuevos tipos de ingredientes sin modificar las clases existentes
- **L:** Todas las clases son intercambiables en sus respectivos contextos
- **I:** Las interfaces son específicas y pequeñas
- **D:** Las clases dependen de abstracciones (como List) no de implementaciones concretas

## Uso de Streams
```java
// Calcular precio total
ingredientes.stream()
    .mapToInt(Ingredientes::getPrecio)
    .sum();

// Filtrar ingredientes seleccionados
catalogoIngredientes.stream()
    .filter(ing -> idsSeleccionados.contains(ing.getId()))
    .collect(Collectors.toList());

// Mostrar ingredientes seleccionados
hamburguesa.getIngredientes().stream()
    .map(ing -> ing.getNombre())
    .toList()
