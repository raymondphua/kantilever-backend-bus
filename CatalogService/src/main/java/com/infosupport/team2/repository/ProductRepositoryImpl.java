package com.infosupport.team2.repository;

import com.infosupport.team2.model.Brand;
import com.infosupport.team2.model.Category;
import com.infosupport.team2.model.Product;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
    public List<Category> getAllCategories() {
        return mongoTemplate.getCollection("products").distinct("categories");
    }

    @Override
    public List<Brand> getAllBrands() {
        return mongoTemplate.getCollection("products").distinct("brand");
    }

    @Override
    public Category findByCategorieCName(String cName) {
        List<BasicDBObject> categories = mongoTemplate.getCollection("products").distinct("categories", new BasicDBObject("categories.cName", new BasicDBObject("$eq", cName)));

        if (categories.size() > 0) {
            return mongoTemplate.getConverter().read(Category.class, categories.get(0));
        }
        return null;
    }

    @Override
    public Category findByCategoryId(String id) {
        List<BasicDBObject> categories = mongoTemplate.getCollection("products").distinct("categories", new BasicDBObject("categories._id", new BasicDBObject("$eq", id)));
        if (categories.size() > 0) {
            return mongoTemplate.getConverter().read(Category.class, categories.get(0));
        }
        return null;
    }

    private Criteria getCriteriaForParam(String property, String[] values) {
        if (property.equals("price") && values.length > 0) {
            return Criteria.where(property.toLowerCase()).lte(Double.parseDouble(values[0]));
        } else if (property.equals("name") && values.length > 0) {
            return Criteria.where(property).regex(Pattern.compile(values[0], Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
        } else
            return Criteria.where(property.toLowerCase()).in(Arrays.asList(values));
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
            default:
                return param;
        }
    }
}
