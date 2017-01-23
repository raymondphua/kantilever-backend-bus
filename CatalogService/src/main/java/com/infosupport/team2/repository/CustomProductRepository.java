package com.infosupport.team2.repository;

import com.infosupport.team2.model.Brand;
import com.infosupport.team2.model.Category;
import com.infosupport.team2.model.PageoableObject;
import com.infosupport.team2.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 11-1-2017.
 */
public interface CustomProductRepository {
    public PageoableObject<Product> filterProducts(Map<String, String> filters);
    public List<Category> getAllCategories();
    public List<Brand> getAllBrands();
    public Category findByCategorieCName(String cName);
    public Category findByCategoryId(String id);
}
