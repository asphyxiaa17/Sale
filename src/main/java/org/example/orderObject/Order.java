package org.example.orderObject;

import java.time.LocalDateTime;


public class Order {
    private LocalDateTime ordData;
    private String shopName;
    private int wheitKg;

    public Order(LocalDateTime ordData, String shopName, int wheitKg) {
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

    public int getWheitKg() {
        return wheitKg;
    }
}
