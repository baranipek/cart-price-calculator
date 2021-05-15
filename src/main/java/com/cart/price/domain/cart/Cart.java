package com.cart.price.domain.cart;

import com.cart.price.domain.store.StoreRepository;
import com.cart.price.exception.ProductIsNotInStockException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cart {

    private final List<CartItem> cartItems = Collections.synchronizedList(new ArrayList<>());

    private StoreRepository storeRepository = new StoreRepository();

    public void addItem(final CartItem cartItem) {
        if (!storeRepository.isInStock(cartItem.getProduct().getProductCode())) {
            throw new ProductIsNotInStockException("Product is not in the stock");
        }
        storeRepository.reduceStock(cartItem.getProduct().getProductCode());
        this.cartItems.add(cartItem);
    }

    public BigDecimal getTotalOrder() {
        return cartItems.stream().map(CartItem::getTotalOrderItem).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}