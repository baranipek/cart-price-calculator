package com.cart.price.util;

import com.cart.price.domain.cart.CartItem;
import com.cart.price.exception.CartItemException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CartItemValidator {

    public void validate(CartItem cartItem) {
        if (cartItem == null) {
            throw new CartItemException("Cart Item can not be null");
        }
        if (cartItem.getProduct() == null) {
            throw new CartItemException("Product can not be null");
        }

        if (cartItem.getProduct().getName() == null) {
            throw new CartItemException("Product name can not be null");
        }
    }

}
