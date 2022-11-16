package com.golovanov.productlist.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
public class ProductEntity {

    @Id
    private Long id;

    private String name;

    private String description;

    private Integer kcal;

}
