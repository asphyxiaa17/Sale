package org.example.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class Order {
    private LocalDateTime orderData;
    private String shopName;
    private BigDecimal weightKg;
    private BigDecimal finalPrice;

    public Order(LocalDateTime orderData, String shopName, BigDecimal weightKg) {
        this.orderData = orderData;
        this.shopName = shopName;
        this.weightKg = weightKg;
    }

    public LocalDateTime getOrderData() {
        return orderData;
    }

    public void setOrderData(LocalDateTime orderData) {
        this.orderData = orderData;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(BigDecimal weightKg) {
        this.weightKg = weightKg;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderData, order.orderData) && Objects.equals(shopName, order.shopName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderData, shopName);
    }
}
