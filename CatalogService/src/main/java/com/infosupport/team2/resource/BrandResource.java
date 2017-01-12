package com.infosupport.team2.resource;

import com.infosupport.team2.model.Brand;
import com.infosupport.team2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Robin on 11-1-2017.
 */
@CrossOrigin
@RestController
public class BrandResource {
    @Autowired
    private ProductRepository productRepo;

    @RequestMapping(value = {"/brands/", "/brands"}, method = RequestMethod.GET)
    public List<Brand> allBrands()
    {
        return productRepo.getAllBrands();
    }
}
