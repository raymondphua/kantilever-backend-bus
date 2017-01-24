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

    public Product(String id, long supplierId, String supplierShort, String name, String description, String imgUrl,  double price, LocalDate availableFrom, LocalDate availableTo, String supplierProductId, Brand brand, List<Category> categories, String cName) {
        this.id = id;
        this.supplierId = supplierId;
        this.supplierShort = supplierShort;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
        this.supplierProductId = supplierProductId;
        this.brand = brand;
        this.categories = categories;
        this.cName = cName;
        generateKey();
    }

    @Id
    private String id;
    private String productKey;
    private String supplierShort;
    private Long supplierId;
    private String name;
    private String description;
    private String imgUrl;
    private double price;
    private LocalDate availableFrom;
    private LocalDate availableTo;
    private String supplierProductId;
    private Brand brand;
    private List<Category> categories;
    private String cName;

    private String generateKey(){
        StringBuilder sb = new StringBuilder();
        sb.append("prd-");
        sb.append(supplierShort);
        sb.append("-");
        sb.append(supplierProductId.replace("-", ""));

        return sb.toString();
    }
}
