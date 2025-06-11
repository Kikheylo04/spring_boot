package com.ventas.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.idat.model.Product;
import com.ventas.idat.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Product save(Product product){
        return repository.save(product);
    }

    public Product update(Long id, Product product) {
        Product productExist = getById(id);
        productExist.setName(product.getName());
        productExist.setDescription(product.getDescription());
        productExist.setPrice(product.getPrice());
        productExist.setStock(product.getStock());
        return repository.save(productExist);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }



}
