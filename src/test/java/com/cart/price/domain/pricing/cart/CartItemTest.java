package com.cart.price.domain.pricing.cart;

import com.cart.price.domain.cart.Cart;
import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.discount.BuyXForYAmountDiscount;
import com.cart.price.domain.discount.BuyXGetYFreeDiscount;
import com.cart.price.domain.pricing.BuyXForYAmountPricing;
import com.cart.price.domain.pricing.BuyXGetFreeYPricing;
import com.cart.price.domain.pricing.Pricing;
import com.cart.price.domain.product.Product;
import com.cart.price.domain.product.UnitProduct;
import com.cart.price.exception.ProductIsNotInStockException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CartItemTest {

    private Cart cart;

    @Test
    void GivenMultipleWatchBuyXForYAmountDiscountProduct_WhenCalculate_ThenReturnTotalAsExpected() {
        Pricing pricing = new BuyXForYAmountPricing();
        cart = new Cart();

        Product watch = new UnitProduct();
        watch.setName("watch");
        watch.setPrice(BigDecimal.TEN);
        watch.setProductCode("productCode");

        CartItem cartItem = new CartItem(pricing);
        cartItem.setProduct(watch);
        cartItem.setAmount(BigDecimal.valueOf(5));
        cartItem.setDiscount(new BuyXForYAmountDiscount(BigDecimal.valueOf(3), BigDecimal.valueOf(9)));

        Product watch1 = new UnitProduct();
        watch1.setName("watch1");
        watch1.setPrice(BigDecimal.valueOf(5));
        watch1.setProductCode("productCode1");

        CartItem cartItem1 = new CartItem(pricing);
        cartItem1.setProduct(watch1);
        cartItem1.setAmount(BigDecimal.valueOf(4));
        cartItem1.setDiscount(new BuyXForYAmountDiscount(BigDecimal.valueOf(3), BigDecimal.valueOf(9)));

        cart.addItem(cartItem);
        cart.addItem(cartItem1);

        assertEquals(cart.getTotalOrder().compareTo(BigDecimal.valueOf(27)), 0);

    }

    @Test
    void GivenMultipleDiscountType_WhenCalculate_ThenReturnTotalAsExpected() {
        Pricing pricing = new BuyXGetFreeYPricing();
        cart = new Cart();
        Product watch = new UnitProduct();
        watch.setName("watch");
        watch.setPrice(BigDecimal.TEN);
        watch.setProductCode("productCode");


        CartItem cartItem = new CartItem(pricing);
        cartItem.setProduct(watch);
        cartItem.setAmount(BigDecimal.valueOf(11));
        cartItem.setDiscount(new BuyXGetYFreeDiscount(3, 2));


        pricing = new BuyXForYAmountPricing();

        Product watch1 = new UnitProduct();
        watch1.setName("watch1");
        watch.setPrice(BigDecimal.TEN);
        watch1.setProductCode("productCode1");

        CartItem cartItem1 = new CartItem(pricing);
        cartItem1.setProduct(watch);
        cartItem1.setAmount(BigDecimal.valueOf(5));
        cartItem1.setDiscount(new BuyXForYAmountDiscount(BigDecimal.valueOf(3), BigDecimal.valueOf(9)));

        cart.addItem(cartItem);
        cart.addItem(cartItem1);

        assertEquals(cart.getTotalOrder().compareTo(BigDecimal.valueOf(65)), 0);

    }

    @Test
    void GivenProductIsNotInTheStock_WhenCalculate_ThenThrowProductIsNotInStockException() {
        Pricing pricing = new BuyXGetFreeYPricing();
        cart = new Cart();
        Product watch = new UnitProduct();
        watch.setName("watch");
        watch.setPrice(BigDecimal.TEN);
        watch.setProductCode("wrongProduct");

        CartItem cartItem = new CartItem(pricing);
        cartItem.setProduct(watch);
        cartItem.setAmount(BigDecimal.valueOf(11));
        cartItem.setDiscount(new BuyXGetYFreeDiscount(3, 2));

        assertThrows(ProductIsNotInStockException.class, () ->  cart.addItem(cartItem));

    }
}
