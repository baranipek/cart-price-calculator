package com.cart.price.domain.discount;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BuyXForYAmountDiscount implements Discount {

    private BigDecimal amount;
    private BigDecimal amountPrice;


}
