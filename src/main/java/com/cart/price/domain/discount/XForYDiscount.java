package com.cart.price.domain.discount;

import java.math.BigDecimal;

public class XForYDiscount implements Discount {

    private BigDecimal amount;
    private BigDecimal amountPrice;

    public XForYDiscount(BigDecimal amount, BigDecimal amountPrice) {
        this.amount = amount;
        this.amountPrice = amountPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountPrice() {
        return amountPrice;
    }

    public void setAmountPrice(BigDecimal amountPrice) {
        this.amountPrice = amountPrice;
    }

}
