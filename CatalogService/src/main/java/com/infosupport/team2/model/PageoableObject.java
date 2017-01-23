package com.infosupport.team2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Raymond Phua on 23-1-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageoableObject<T> {

    private long total;
    private int pageSize;
    private int currentPage;
    private List<T> items;
}
