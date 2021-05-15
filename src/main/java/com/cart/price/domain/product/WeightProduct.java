package com.cart.price.domain.product;


import com.cart.price.enumeration.WeightUnit;


public class WeightProduct extends Product {

    private WeightUnit weightUnit;

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}

