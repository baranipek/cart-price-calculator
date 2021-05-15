package com.cart.price.domain.pricing;


import com.cart.price.domain.cart.CartItem;
import com.cart.price.domain.product.WeightProduct;
import com.cart.price.util.CartItemValidator;
import com.cart.price.util.WeightConverter;

import java.math.BigDecimal;

public class WeightPricing implements Pricing {
    @Override
    public BigDecimal calculate(final CartItem cartItem) {
        CartItemValidator.validate(cartItem);

        final WeightProduct product = (WeightProduct) cartItem.getProduct();
        final BigDecimal amount = cartItem.getAmount();
        final BigDecimal price = product.getPrice();

        return price.multiply(WeightConverter.convert(product.getWeightUnit(),
                cartItem.getWeightUnit()).apply(amount));
    }
}
