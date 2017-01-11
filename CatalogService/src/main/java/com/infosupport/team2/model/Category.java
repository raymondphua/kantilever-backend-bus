package com.infosupport.team2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by Raymond Phua on 10-1-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private String categoryId;
    private String name;
    private String cName;
}
