package com.cart.price.domain.discount;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyXGetYFreeDiscount implements Discount {

    private int buyNProductAmount;
    private int freeProductAmount;
    
}
