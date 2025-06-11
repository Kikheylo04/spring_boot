package com.ventas.idat.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Size(max = 255, message = "La descripcion no puede superar los 255 caracteres")
    private String description;

    @Positive(message = "El precio debe ser positivo")
    private double price;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    


}
