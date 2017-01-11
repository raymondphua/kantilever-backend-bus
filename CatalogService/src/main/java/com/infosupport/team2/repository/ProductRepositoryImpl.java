package com.infosupport.team2.repository;

import com.infosupport.team2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 11-1-2017.
 */
public class ProductRepositoryImpl implements CustomProductRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Product> filterProducts(Map<String, String> filters) {
        Query productFilter = new Query();

        filters.forEach((k, v) -> {
            String property = getPropertyForParam(k);
            if (property != null) {
                productFilter.addCriteria(getCriteriaForParam(property, v.split(",")));
            }
        });

        return mongoTemplate.find(productFilter, Product.class);
    }

    @Override
    public List<String> getAllCategories() {
        return mongoTemplate.getCollection("products").distinct("categories._id");
    }

    @Override
    public List<String> getAllBrands() {
        return mongoTemplate.getCollection("products").distinct("brand._id");
    }

    private Criteria getCriteriaForParam(String property, String[] values) {
        return Criteria.where(property).in(Arrays.asList(values));
    }

    private String getPropertyForParam(String param) {
        switch (param.toLowerCase()) {
            case "brands":
            case "brand":
                return "brand._id";
            case "categories":
            case "category":
            case "categorie":
                return "categories._id";
        }

        return null;
    }
}
