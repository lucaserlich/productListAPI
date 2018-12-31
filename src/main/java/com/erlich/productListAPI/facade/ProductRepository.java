/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erlich.productListAPI.facade;

import com.erlich.productListAPI.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Administrador
 */
public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {
}
