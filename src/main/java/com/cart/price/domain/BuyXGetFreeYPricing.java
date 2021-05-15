package com.cart.price.domain;

import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.discount.BuyXGetYFreeDiscount;
import com.cart.price.exception.SufficientAmountForSpecificDiscountException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyXGetFreeYPricing implements Pricing {

    @Override
    public BigDecimal calculate(final CartItem cartItem) {

        BuyXGetYFreeDiscount discount = (BuyXGetYFreeDiscount) cartItem.getDiscount();
        int orderAmount = cartItem.getAmount().intValue();
        int totalDiscountAmount = discount.getBuyNProductAmount() + discount.getFreeProductAmount();

        if (orderAmount < totalDiscountAmount) {
            throw new SufficientAmountForSpecificDiscountException("To use from this discount, " +
                    "you should take more then " + totalDiscountAmount + " items");
        }

        final BigDecimal price = cartItem.getProduct().getPrice();
        final BigDecimal discountPrice = price.multiply(this.getPercentageDiscount(discount));


        int discountedItems = (orderAmount / totalDiscountAmount) * totalDiscountAmount;
        int noDiscountedItems = orderAmount - discountedItems;


        return BigDecimal.valueOf(discountedItems).multiply(discountPrice).add(BigDecimal.valueOf(noDiscountedItems).multiply(price));
    }

    public BigDecimal getPercentageDiscount(BuyXGetYFreeDiscount discount) {
        return BigDecimal.ONE.min(BigDecimal.valueOf(discount.getFreeProductAmount()).
                divide(BigDecimal.valueOf(discount.getBuyNProductAmount() + discount.getFreeProductAmount()), 2, RoundingMode.HALF_UP));
    }
}
