package com.cart.price.domain.pricing;

import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.discount.BuyXGetYFreeDiscount;
import com.cart.price.exception.SufficientAmountForSpecificDiscountException;

import java.math.BigDecimal;

public class BuyXGetFreeYPricing implements Pricing {

    @Override
    public BigDecimal calculate(final CartItem cartItem) {

        BuyXGetYFreeDiscount discount = (BuyXGetYFreeDiscount) cartItem.getDiscount();
        int orderAmount = cartItem.getAmount().intValue();

        if (orderAmount < discount.getTotalProduct()) {
            throw new SufficientAmountForSpecificDiscountException("To use from this discount, " +
                    "you should take more then " + discount.getTotalProduct() + " items");
        }

        final BigDecimal price = cartItem.getProduct().getPrice();
        final BigDecimal discountPrice = price.multiply(discount.getPercentageDiscount());


        int discountedItems = (orderAmount / discount.getTotalProduct()) * discount.getTotalProduct();
        int noDiscountedItems = orderAmount - discountedItems;


        return BigDecimal.valueOf(discountedItems).multiply(discountPrice).add(BigDecimal.valueOf(noDiscountedItems).multiply(price));
    }
}
