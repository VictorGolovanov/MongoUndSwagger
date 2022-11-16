package com.golovanov.productlist.dto;

import com.golovanov.productlist.entity.ProductEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDTO {

    private Long id;
    private String name;
    private List<ProductEntity> products = new ArrayList<>();
    private int totalKcal;

}
