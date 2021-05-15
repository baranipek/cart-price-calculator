package com.cart.price.domain.cart;

import com.cart.price.domain.discount.Discount;
import com.cart.price.domain.pricing.Pricing;
import com.cart.price.domain.product.Product;
import com.cart.price.enumeration.WeightUnit;

import java.math.BigDecimal;

public class CartItem {

    private Product product;
    private BigDecimal amount;
    private WeightUnit weightUnit;
    private Discount discount;
    private Pricing pricing;


    public CartItem(Pricing pricing) {
        this.pricing = pricing;
    }

    public BigDecimal getTotalOrderItem() throws Exception {
        return this.pricing.doPricing(this);
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

}
