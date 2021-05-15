package com.cart.price.domain.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyXGetYFreeDiscount implements Discount {

    private int buyNProductAmount;
    private int freeProductAmount;

    public BuyXGetYFreeDiscount(int buyNProductAmount, int getYFreeProduct) {
        this.buyNProductAmount = buyNProductAmount;
        this.freeProductAmount = getYFreeProduct;
    }

    public int getFreeProductAmount() {
        return freeProductAmount;
    }

    public void setFreeProductAmount(int freeProductAmount) {
        this.freeProductAmount = freeProductAmount;
    }

    public int getBuyNProductAmount() {
        return buyNProductAmount;
    }

    public void setBuyNProductAmount(int buyNProductAmount) {
        this.buyNProductAmount = buyNProductAmount;
    }

    public int getCostProductAsDouble() {
        return buyNProductAmount;
    }

    public int getFreeProduct() {
        return freeProductAmount;
    }


    public int getTotalProduct() {
        return freeProductAmount + buyNProductAmount;
    }

    public BigDecimal getPercentageDiscount() {
        return BigDecimal.ONE.min(BigDecimal.valueOf(getFreeProduct()).
                divide(BigDecimal.valueOf(getTotalProduct()), 2, RoundingMode.HALF_UP));
    }

}
