package com.cart.price.domain;


import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.discount.BuyXForYAmountDiscount;
import com.cart.price.exception.SufficientAmountForSpecificDiscountException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyXForYAmountPricing implements Pricing {

    @Override
    public BigDecimal calculate(CartItem orderItem) {

        BuyXForYAmountDiscount discount = (BuyXForYAmountDiscount) orderItem.getDiscount();
        BigDecimal orderAmount = orderItem.getAmount();

        if (discount.getAmount().compareTo(orderAmount) > 0) {
            throw new SufficientAmountForSpecificDiscountException("You should buy more then " + discount.getAmount());
        }

        return orderAmount.multiply(discount.getAmountPrice()).divide(discount.getAmount(), 2, RoundingMode.HALF_UP);
    }
}
