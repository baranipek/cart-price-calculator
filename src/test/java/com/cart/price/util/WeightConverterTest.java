package com.cart.price.util;


import com.cart.price.enumeration.WeightUnit;
import com.cart.price.exception.WeightConvertionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WeightConverterTest {

    @Test
    public void GivenNullInputWhenConvertWeightThrowIllegalConversationException() {
        Assertions.assertThrows(WeightConvertionException.class, () -> {
            WeightConverter.convert(null, WeightUnit.POUND);
        });
    }

    @Test
    public void GivenNullOutputWhenConvertWeightThrowIllegalConversationException() {
        Assertions.assertThrows(WeightConvertionException.class, () -> {
            WeightConverter.convert(WeightUnit.OUNCE, null);
        });
    }

    @Test
    public void GivenOneOunce_WhenConvertWeight_ThenReturn16Pound() {

        Assertions.assertEquals(WeightConverter.convert(WeightUnit.OUNCE, WeightUnit.POUND).
                apply(BigDecimal.ONE), BigDecimal.valueOf(16));
    }


    @Test
    public void Given16Pound_WhenConvertWeight_ThenReturn1Ounce() {

        Assertions.assertEquals(WeightConverter.convert(WeightUnit.POUND, WeightUnit.OUNCE).
                apply(BigDecimal.valueOf(16)), BigDecimal.valueOf(1));
    }
}