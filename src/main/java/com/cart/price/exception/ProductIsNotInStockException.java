package com.cart.price.exception;

public class ProductIsNotInStockException extends RuntimeException {
    public ProductIsNotInStockException(String message) {
        super(message);
    }
}
