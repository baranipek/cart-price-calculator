
package com.cart.price.util;

import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.UnitPricing;
import com.cart.price.domain.product.Product;
import com.cart.price.domain.product.UnitProduct;
import com.cart.price.exception.CartItemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CartItemValidatorTest {

    @Test
    public void GivenNullCartItem_WhenValidateCartItem_ThenThrowCartItemException() {
        Assertions.assertThrows(CartItemException.class, () -> {
            CartItemValidator.validate(null);
        });
    }

    @Test
    public void GivenNullProductCartItem_WhenValidateCartItem_ThenThrowCartItemException() {
        CartItem cartItem = new CartItem(new UnitPricing());
        cartItem.setProduct(null);
        Assertions.assertThrows(CartItemException.class, () -> {
            CartItemValidator.validate(cartItem);
        });
    }

    @Test
    public void GivenNullProductNameCartItem_WhenValidateCartItem_ThenThrowCartItemException() {
        CartItem cartItem = new CartItem(new UnitPricing());
        Product product = new UnitProduct();
        product.setName(null);
        cartItem.setProduct(product);
        Assertions.assertThrows(CartItemException.class, () -> {
            CartItemValidator.validate(cartItem);
        });
    }
}
