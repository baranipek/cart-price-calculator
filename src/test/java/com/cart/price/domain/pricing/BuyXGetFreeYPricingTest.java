package com.cart.price.domain.pricing;

import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.discount.BuyXGetYFreeDiscount;
import com.cart.price.domain.product.Product;
import com.cart.price.domain.product.UnitProduct;
import com.cart.price.exception.SufficientAmountForSpecificDiscountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyXGetFreeYPricingTest {

    private BuyXGetFreeYPricing pricing;

    @Test
    void Given3Buy2FreeWatch_WhenCalculate_ThenReturn50AsTotal() {
        pricing = new BuyXGetFreeYPricing();

        Product watch = new UnitProduct();
        watch.setName("watch");
        watch.setPrice(BigDecimal.TEN);

        CartItem cartItem = new CartItem(pricing);
        cartItem.setProduct(watch);
        cartItem.setAmount(BigDecimal.valueOf(11));
        cartItem.setDiscount(new BuyXGetYFreeDiscount(3, 2));

        assertEquals(pricing.calculate(cartItem).compareTo(BigDecimal.valueOf(50)), 0);

    }


    @Test
    void Given3Buy2FreeWatchAdd3Amount_WhenCalculate_ThenThrowAmountIsNotSufficientException() {
        pricing = new BuyXGetFreeYPricing();

        Product watch = new UnitProduct();
        watch.setName("watch");
        watch.setPrice(BigDecimal.TEN);

        CartItem cartItem = new CartItem(pricing);
        cartItem.setProduct(watch);
        cartItem.setAmount(BigDecimal.valueOf(3));
        cartItem.setDiscount(new BuyXGetYFreeDiscount(3, 2));

        Assertions.assertThrows(SufficientAmountForSpecificDiscountException.class, () -> pricing.calculate(cartItem));

    }
}