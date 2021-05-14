package com.cart.price.util;

import com.cart.price.enumeration.WeightUnit;
import com.cart.price.exception.WeightConvertionException;

import java.math.BigDecimal;
import java.util.function.Function;

public class WeightConverter {

    public static Function<BigDecimal, BigDecimal> convert(WeightUnit in, WeightUnit out) throws WeightConvertionException {

        if (in == null) {
            throw new WeightConvertionException("input unit is null");
        }
        if (out == null) {
            throw new WeightConvertionException("out unit is null");
        }
        if (in == out) {
            return weight -> weight;
        }
        switch (in) {
            case POUND:
                return weight -> weight.divide(BigDecimal.valueOf(16));
            case OUNCE:
                return weight -> weight.multiply(BigDecimal.valueOf(16));
            default:
                throw new WeightConvertionException("Wrong parameter");
        }

    }
}