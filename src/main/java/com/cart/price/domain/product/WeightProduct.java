package com.cart.price.domain.product;


import com.cart.price.enumeration.WeightUnit;
import lombok.Data;


@Data
public class WeightProduct extends Product {

    private WeightUnit weightUnit;

}

