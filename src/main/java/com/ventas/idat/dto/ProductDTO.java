package com.ventas.idat.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Size(max = 255, message = "La descripcion no puede superar los 255 caracteres")
    private String description;

    @Positive(message = "El precio debe ser positivo")
    private double price;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

}
