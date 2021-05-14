package com.cart.price.domain.discount;

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

    public double getCostProductAsDouble() {
        return buyNProductAmount;
    }

    public double getFreeProductAsDouble() {
        return freeProductAmount;
    }

    public int getTotalProductDiscount() {
        return freeProductAmount + buyNProductAmount;
    }

    public double getTotalProductAsDouble() {
        return freeProductAmount + buyNProductAmount;
    }

    public double getPercentageDiscount() {

        return (1 - getFreeProductAsDouble() / getTotalProductAsDouble());
    }

}
