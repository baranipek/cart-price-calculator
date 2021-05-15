package com.cart.price.domain.product;


import lombok.Data;

import java.math.BigDecimal;


@Data
public abstract class Product {

    private String productCode;
    private String name;
    private BigDecimal price;

}
