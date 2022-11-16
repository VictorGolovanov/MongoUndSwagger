package com.golovanov.productlist.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "lists")
@Getter
@Setter
public class ListEntity {
    @Id
    private Long id;

    private String name;

    private List<ProductEntity> products = new ArrayList<>();
}
