package com.infosupport.team2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Raymond Phua on 10-1-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private Long leverancierId;
    private String name;
    private String description;
    private String imgUrl;
    private double price;
    private LocalDate availableFrom;
    private LocalDate availableTo;
    private String supplierProductId;
    private Brand brand;
    private List<Category> categories;

}
