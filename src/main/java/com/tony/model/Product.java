package com.tony.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
@Data
public class Product {

    private String id;
    private String name;
    private Integer price;
}