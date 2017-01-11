package com.infosupport.team2.repository;

import com.infosupport.team2.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 11-1-2017.
 */
public interface CustomProductRepository {
    public List<Product> filterProducts(Map<String, String> filters);
    public List<String> getAllCategories();
    public List<String> getAllBrands();
}
