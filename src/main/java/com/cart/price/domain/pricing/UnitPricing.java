package com.cart.price.domain.pricing;

import com.cart.price.domain.cart.CartItem;
import com.cart.price.util.CartItemValidator;

import java.math.BigDecimal;


public class UnitPricing implements Pricing {

    @Override
    public BigDecimal calculate(CartItem cartItem) {
        CartItemValidator.validate(cartItem);
        return cartItem.getProduct().getPrice().multiply(cartItem.getAmount());
    }
}
