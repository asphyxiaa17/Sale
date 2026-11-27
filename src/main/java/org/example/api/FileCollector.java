package org.example.api;

import org.example.entity.Order;

import java.util.List;

public interface FileCollector {
    public void storeOrderLine(List<Order> orderDateDesc);
}
