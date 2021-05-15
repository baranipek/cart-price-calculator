package com.cart.price.domain.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cart {

    private final List<CartItem> cartItems = Collections.synchronizedList(new ArrayList<>());

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(final CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public BigDecimal getTotalOrder() {
        return cartItems.stream().map(CartItem::getTotalOrderItem).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}