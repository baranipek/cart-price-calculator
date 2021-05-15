package com.cart.price.domain.pricing;

import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.product.WeightProduct;
import com.cart.price.enumeration.WeightUnit;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightPricingTest {

    private WeightPricing pricing;

    @Test
    void Given4PoundApple_WhenCalculate_ThenReturn40AsTotal() {
        pricing = new WeightPricing();
        WeightProduct apple = new WeightProduct();
        apple.setName("apple");
        apple.setPrice(BigDecimal.TEN);
        apple.setWeightUnit(WeightUnit.POUND);

        CartItem cartItem = new CartItem(pricing);
        cartItem.setWeightUnit(WeightUnit.POUND);
        cartItem.setProduct(apple);
        cartItem.setAmount(BigDecimal.valueOf(4));

        assertEquals(pricing.calculate(cartItem), BigDecimal.valueOf(40));
    }

    @Test
    void Given4PoundApple_WhenCalculate_ThenReturnOunceTwoPointFive() {
        pricing = new WeightPricing();
        WeightProduct apple = new WeightProduct();
        apple.setName("apple");
        apple.setPrice(BigDecimal.TEN);
        apple.setWeightUnit(WeightUnit.POUND);

        CartItem cartItem = new CartItem(pricing);
        cartItem.setWeightUnit(WeightUnit.OUNCE);
        cartItem.setProduct(apple);
        cartItem.setAmount(BigDecimal.valueOf(4));

        assertEquals(pricing.calculate(cartItem).compareTo(BigDecimal.valueOf(2.50)), 0);
    }


    @Test
    void Given4OunceApple_WhenCalculate_ThenReturnOunceTwoPointFive() {
        pricing = new WeightPricing();
        WeightProduct apple = new WeightProduct();
        apple.setName("apple");
        apple.setPrice(BigDecimal.TEN);
        apple.setWeightUnit(WeightUnit.OUNCE);

        CartItem cartItem = new CartItem(pricing);
        cartItem.setWeightUnit(WeightUnit.POUND);
        cartItem.setProduct(apple);
        cartItem.setAmount(BigDecimal.valueOf(4));

        assertEquals(pricing.calculate(cartItem).compareTo(BigDecimal.valueOf(640)), 0);
    }
}