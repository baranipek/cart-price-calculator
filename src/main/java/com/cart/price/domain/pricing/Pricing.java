package com.cart.price.domain.pricing;


import com.cart.price.domain.cart.CartItem;

import java.math.BigDecimal;

public interface Pricing {
    BigDecimal doPricing(CartItem cartItem) throws Exception;
}
