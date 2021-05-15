package com.cart.price.domain.discount;

import java.math.BigDecimal;

public class BuyXGetYFreeDiscount implements Discount {

    private BigDecimal buyNProductAmount;
    private BigDecimal freeProductAmount;

    public BuyXGetYFreeDiscount(BigDecimal buyNProductAmount, BigDecimal getYFreeProduct) {
        this.buyNProductAmount = buyNProductAmount;
        this.freeProductAmount = getYFreeProduct;
    }

    public BigDecimal getFreeProductAmount() {
        return freeProductAmount;
    }

    public void setFreeProductAmount(BigDecimal freeProductAmount) {
        this.freeProductAmount = freeProductAmount;
    }

    public BigDecimal getBuyNProductAmount() {
        return buyNProductAmount;
    }

    public void setBuyNProductAmount(BigDecimal buyNProductAmount) {
        this.buyNProductAmount = buyNProductAmount;
    }

    public BigDecimal getCostProductAsDouble() {
        return buyNProductAmount;
    }

    public BigDecimal getFreeProduct() { return freeProductAmount; }


    public BigDecimal getTotalProduct() { return freeProductAmount.add(buyNProductAmount); }

    public BigDecimal getPercentageDiscount() {
        return (BigDecimal.ONE.min(getFreeProduct().divide(getTotalProduct())));
    }

}
