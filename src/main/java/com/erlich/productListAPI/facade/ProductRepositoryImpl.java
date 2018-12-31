/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erlich.productListAPI.facade;

import com.erlich.productListAPI.entity.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author Administrador
 */
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    private final static String regex = "^[a-zA-Z0-9]{2,}$";
    private final Pattern pattern;

    @Autowired
    public ProductRepositoryImpl(MongoTemplate mongoTemplate) {
        this.pattern = Pattern.compile(regex);
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Product> aggregate(String keyword) {
        List<String> keywords = new ArrayList<>(Arrays.asList(keyword.split(" ")));

        List<Criteria> regExs = new ArrayList<>();
        keywords.forEach((String kw) -> {
            if (validateKeyword(kw)) {
                regExs.add(Criteria.where("stack").in(Pattern.compile("" + kw + "", Pattern.CASE_INSENSITIVE)));
                regExs.add(Criteria.where("targetMarket").in(Pattern.compile("" + kw + "", Pattern.CASE_INSENSITIVE)));
            }
        });

        if (regExs.size() < 1) {
            return new ArrayList<>();
        }

        Criteria criteria = new Criteria().orOperator(regExs.toArray(new Criteria[regExs.size()]));

        Query query = new Query();
        query.addCriteria(criteria);

        return mongoTemplate.find(query, Product.class);
    }

    public boolean validateKeyword(String keyword) {
        Matcher matcher = pattern.matcher(keyword);

        return matcher.matches();
    }
}
