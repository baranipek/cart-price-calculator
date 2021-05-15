package com.cart.price.domain.pricing;

import com.cart.price.domain.BuyXForYAmountPricing;
import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.discount.BuyXForYAmountDiscount;
import com.cart.price.domain.product.Product;
import com.cart.price.domain.product.UnitProduct;
import com.cart.price.exception.SufficientAmountForSpecificDiscountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyXForYAmountPricingTest {

    private BuyXForYAmountPricing pricing;

    @Test
    void Given3BuyPay9Watch_WhenCalculate_ThenReturn15AsTotal() {
        pricing = new BuyXForYAmountPricing();

        Product watch = new UnitProduct();
        watch.setName("watch");
        watch.setPrice(BigDecimal.TEN);

        CartItem cartItem = new CartItem(pricing);
        cartItem.setProduct(watch);
        cartItem.setAmount(BigDecimal.valueOf(5));
        cartItem.setDiscount(new BuyXForYAmountDiscount(BigDecimal.valueOf(3), BigDecimal.valueOf(9)));

        assertEquals(pricing.calculate(cartItem).compareTo(BigDecimal.valueOf(15)), 0);

    }

    @Test
    void Given3BuyPay9WatchAdd2ProductToCart_WhenCalculate_ThenThrowAmountIsNotSufficientException() {
        pricing = new BuyXForYAmountPricing();

        Product watch = new UnitProduct();
        watch.setName("watch");
        watch.setPrice(BigDecimal.TEN);

        CartItem cartItem = new CartItem(pricing);
        cartItem.setProduct(watch);
        cartItem.setAmount(BigDecimal.valueOf(2));
        cartItem.setDiscount(new BuyXForYAmountDiscount(BigDecimal.valueOf(3), BigDecimal.valueOf(9)));

        Assertions.assertThrows(SufficientAmountForSpecificDiscountException.class, () -> pricing.calculate(cartItem));


    }

}