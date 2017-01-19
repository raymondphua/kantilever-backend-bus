package com.infosupport.team2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by djones on 1/19/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private List<Product> orderedProducts;

}
