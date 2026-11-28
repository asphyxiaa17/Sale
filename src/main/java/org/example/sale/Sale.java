
package org.example.sale;

import org.example.intr.intrpromotionQueue;
import org.example.orderObject.Order;
import org.example.orderObject.OrderReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sale implements intrpromotionQueue {
    private final List<Order> orders;
    private BigDecimal promoSize;
    private BigDecimal promoStep;
    private BigDecimal offerPrice;


    public Sale(List<Order> orders, BigDecimal promoSize, BigDecimal promoStep, BigDecimal offerPrice) {
        this.orders = orders;
        this.promoSize = promoSize;
        this.promoStep = promoStep;
        this.offerPrice = offerPrice;
    }

    @Override

    public List<Order> discount() {
        List<Order> orderDateDesc = new ArrayList<>(orders);
        Collections.sort(orderDateDesc, Comparator.comparing(Order::getOrdData).reversed());
        for (Order order : orderDateDesc) {
            if (promoSize.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal finlePrice = order.getWheitKg().add(offerPrice).multiply(promoSize);
                order.setFinlePrice(finlePrice);
                promoSize = promoSize.subtract(promoStep);
            } else {
                BigDecimal finlePrice = order.getWheitKg().add(offerPrice);
                order.setFinlePrice(finlePrice);
            }
        }
        return orderDateDesc;
    }
}
