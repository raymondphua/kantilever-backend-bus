package com.infosupport.team2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Robin on 23-1-2017.
 */
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDataModel {
    @Getter
    @Setter
    private String orderKey;
    private List<ProductDataModel> orderedProducts;

    public OrderDataModel(String orderKey, List<ProductDataModel> orderedProducts, CustomerDataModel customer){
        this.orderKey = orderKey;
        this.orderedProducts = orderedProducts;
        this.customer = customer;
    }

    @JsonProperty("products")
    public List<ProductDataModel> getProductKeys(){
        return orderedProducts;
    }

    @JsonProperty("orderedProducts")
    public void setProductKeys(List<ProductDataModel> data){
        this.orderedProducts = data;
    }

    @Getter
    @Setter
    private CustomerDataModel customer;
}
