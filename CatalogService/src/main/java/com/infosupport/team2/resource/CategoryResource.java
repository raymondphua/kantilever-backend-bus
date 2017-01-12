package com.infosupport.team2.resource;

import com.infosupport.team2.model.Category;
import com.infosupport.team2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<Category> allBrands(@RequestParam(value = "name", required = false) String cName)
    {
        if(cName == null || cName.isEmpty())
            return repository.getAllCategories();
        else
        {
            List<Category> categories = new ArrayList<Category>();
            categories.add(repository.findByCategorieCName(cName));
            return categories;
        }
    }

    @RequestMapping(value = {"/categories/{id}"}, method = RequestMethod.GET)
    public Category getById(@PathVariable String id)
    {
        return repository.findByCategoryId(id);
    }
}
