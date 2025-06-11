package com.ventas.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ventas.idat.exception.NotFoundException;
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
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Product with ID=" + id + " not exist"));
    }

    public Page<Product> findByName(String name, PageRequest page) {
        return repository.findByNameContainingIgnoreCase(name, page);
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
        if(!repository.existsById(id)) {
            throw new NotFoundException("Product not found");
        }
        repository.deleteById(id);
    }



}
