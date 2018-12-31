/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erlich.productListAPI.facade;

import com.erlich.productListAPI.entity.Product;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface  ProductRepositoryCustom {
    List<Product> aggregate(String keyword);
}
