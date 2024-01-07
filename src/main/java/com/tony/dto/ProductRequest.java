package com.tony.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class ProductRequest {

    @NonNull
    private String name;
    @NonNull
    private Integer price;

}
