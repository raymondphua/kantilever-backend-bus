package com.infosupport.team2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Robin on 23-1-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessKeyModel {
    private Long id;
    private String orderBKey;
    private List<String> productBKeys;
    private String customerBKey;
}
