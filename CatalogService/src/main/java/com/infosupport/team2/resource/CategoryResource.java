package com.infosupport.team2.resource;

import com.infosupport.team2.model.Category;
import com.infosupport.team2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Robin on 11-1-2017.
 */
@CrossOrigin
@RestController
public class CategoryResource {
    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = {"/categories/", "/categories"}, method = RequestMethod.GET)
    public List<Category> allBrands()
    {
        return repository.getAllCategories();
    }

    @RequestMapping(value = {"/categories/{cName}"}, method = RequestMethod.GET)
    public Category getByCName(@PathVariable String cName)
    {
        return repository.findByCategorieCName(cName);
    }
}
