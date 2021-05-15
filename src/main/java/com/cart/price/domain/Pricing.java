package com.cart.price.domain;


import com.cart.price.domain.cart.CartItem;

import java.math.BigDecimal;

public interface Pricing {
    BigDecimal calculate(CartItem cartItem);

}
