package com.infosupport.team2.resource;

import com.infosupport.team2.model.Product;
import com.infosupport.team2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 10-1-2017.
 */
@RestController
public class ProductResource {
    @Autowired
    private ProductRepository productRepo;

    @RequestMapping(value = {"/product/", "/product"}, method = RequestMethod.GET)
    public List<Product> allProducts(@RequestParam Map<String,String> allRequestParams, ModelMap model){
        return productRepo.findAll();
    }

}
