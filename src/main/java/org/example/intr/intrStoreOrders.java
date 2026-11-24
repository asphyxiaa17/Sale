package org.example.intr;

import org.example.orderObject.Order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface intrStoreOrders {
    public void storeOrderLine(List<Order> orderDateDesc);
}
