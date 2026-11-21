package org.example.orderObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Order {
    private LocalDateTime ordData;
    private String shopName;
    private BigDecimal wheitKg;
    private BigDecimal finlePrice;

    public Order(LocalDateTime ordData, String shopName, BigDecimal wheitKg) {
        this.ordData = ordData;
        this.shopName = shopName;
        this.wheitKg = wheitKg;
    }

    public LocalDateTime getOrdData() {
        return ordData;
    }

    public String getShopName() {

        return shopName;
    }

    public BigDecimal getWheitKg() {

        return wheitKg;
    }

    public BigDecimal getFinlePrice() {
        return finlePrice;
    }

    public void setFinlePrice(BigDecimal finlePrice) {
        this.finlePrice = finlePrice;
    }

    public void setOrdData(LocalDateTime ordData) {
        this.ordData = ordData;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setWheitKg(BigDecimal wheitKg) {
        this.wheitKg = wheitKg;
    }
}
