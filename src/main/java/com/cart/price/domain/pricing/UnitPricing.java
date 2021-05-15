package com.cart.price.domain.pricing;

import com.cart.price.domain.cart.CartItem;

import java.math.BigDecimal;




public class UnitPricing implements Pricing  {

    @Override
    public BigDecimal doPricing(CartItem cartItem) {
        return cartItem.getProduct().getPrice().multiply(cartItem.getAmount());
    }
}
