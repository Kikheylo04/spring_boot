package com.ventas.idat.repository;

import com.ventas.idat.model.Product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    Page<Product> findByName(String name, PageRequest pageable);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
