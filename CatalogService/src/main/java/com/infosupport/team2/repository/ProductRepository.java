package com.infosupport.team2.repository;

import com.infosupport.team2.model.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by Raymond Phua on 10-1-2017.
 */
public interface ProductRepository extends MongoRepository<Product, String>{

    //public List<Product> filterProducts(Map<String, String> filters);
}
