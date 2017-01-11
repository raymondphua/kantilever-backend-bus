package com.infosupport.team2.resource;

import com.infosupport.team2.model.Product;
import com.infosupport.team2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 10-1-2017.
 */
@CrossOrigin
@RestController
public class ProductResource {
    @Autowired
    private ProductRepository productRepo;

    @RequestMapping(value = {"/products/", "/products"}, method = RequestMethod.GET)
    public List<Product> allProducts(@RequestParam Map<String,String> allRequestParams, ModelMap model){
        return productRepo.filterProducts(allRequestParams);
    }

    @RequestMapping(value = {"/categories/", "/categories"}, method = RequestMethod.GET)
    public List<String> allCategories()
    {
        return productRepo.getAllCategories();
    }

    @RequestMapping(value = {"/brands/", "/brands"}, method = RequestMethod.GET)
    public List<String> allBrands()
    {
        return productRepo.getAllBrands();
    }

}
