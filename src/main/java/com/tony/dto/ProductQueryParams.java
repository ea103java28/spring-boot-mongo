package com.tony.dto;

import com.tony.constant.SortRule;
import lombok.Data;

@Data
public class ProductQueryParams {


    private String keyword;
    private Integer priceFrom;
    private Integer priceTo;
    private String orderBy;
    private SortRule sortRule;

}
