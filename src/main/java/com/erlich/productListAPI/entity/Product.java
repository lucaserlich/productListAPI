/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erlich.productListAPI.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Administrador
 */
// tutorials used
// https://grokonez.com/spring-framework/spring-data/spring-boot-angular-6-example-spring-data-rest-mongodb-crud-example
// https://www.javacodegeeks.com/2016/04/data-aggregation-spring-data-mongodb-spring-boot.html
// https://start.spring.io/
// https://www.programcreek.com/java-api-examples/index.php?api=org.springframework.data.mongodb.core.query.Criteria
// https://www.mkyong.com/regular-expressions/regular-expression-case-sensitive-example-java/
// https://howtodoinjava.com/regex/java-regex-validate-the-minmax-length-of-input-text/
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    private String productName;
    private String description;
    private List<String> targetMarket;
    private List<String> stack;

    public Product() {
        this.targetMarket = new ArrayList<>();
        this.stack = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTargetMarket() {
        return targetMarket;
    }

    public void setTargetMarket(List<String> targetMarket) {
        this.targetMarket = targetMarket;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + '}';
    }

}
