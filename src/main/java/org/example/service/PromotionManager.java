
package org.example.service;

import org.example.api.DiscountCalculator;
import org.example.entity.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PromotionManager implements DiscountCalculator {
    private final List<Order> orders;
    private BigDecimal promoSize;
    private BigDecimal promoStep;
    private BigDecimal offerPrice;

    public PromotionManager(List<Order> orders, BigDecimal promoSize, BigDecimal promoStep, BigDecimal offerPrice) {
        this.orders = orders;
        this.promoSize = promoSize;
        this.promoStep = promoStep;
        this.offerPrice = offerPrice;
    }

    @Override
    public List<Order> discount() {
        List<Order> orderDateDesc = new ArrayList<>(orders);
        Collections.sort(orderDateDesc, Comparator.comparing(Order::getOrderData));
        for (Order order : orderDateDesc) {
            if (promoSize.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal localSize = promoSize;
                BigDecimal finalPrice = order.getWeightKg().multiply(offerPrice).multiply(localSize);
                order.setFinalPrice(finalPrice);
                promoSize = localSize.subtract(promoStep);
            } else {
                BigDecimal finalPrice = order.getWeightKg().multiply(offerPrice);
                order.setFinalPrice(finalPrice);
            }
        }
        return orderDateDesc;
    }
}
