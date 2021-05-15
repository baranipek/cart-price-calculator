package com.cart.price.exception;

public class SufficientAmountForSpecificDiscountException extends RuntimeException {
    public SufficientAmountForSpecificDiscountException (String message) {
        super(message);
    }
}
