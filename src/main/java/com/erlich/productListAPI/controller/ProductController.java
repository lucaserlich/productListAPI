/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erlich.productListAPI.controller;

import com.erlich.productListAPI.entity.Product;
import com.erlich.productListAPI.facade.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);

        return products;
    }

    @GetMapping("products/search")
    public List<Product> defaultList() {
        return getAllProducts();
    }

    @GetMapping("products/search/{keyword}")
    public List<Product> findList(@PathVariable String keyword) {
        List<Product> products = repository.aggregate(keyword);
        return products;
    }

}
