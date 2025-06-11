package com.ventas.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ventas.idat.dto.ProductDTO;
import com.ventas.idat.model.Product;
import com.ventas.idat.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> listAll() {
        return ResponseEntity.ok().body(productService.listAll());
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<Page<Product>> getProductsByName(@RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Product> result = productService.findByName(name, pageable);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDTO productDto) {
        Product product = convertToEntity(productDto);
        Product productSaved = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        return product;
    }

}
