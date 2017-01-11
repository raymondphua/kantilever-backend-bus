package com.infosupport.team2.repository;

import com.infosupport.team2.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Raymond Phua on 10-1-2017.
 */
public interface ProductRepository extends MongoRepository<Product, String>, CustomProductRepository{

    //public List<Product> filterProducts(Map<String, String> filters);
}
