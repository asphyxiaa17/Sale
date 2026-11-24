package org.example;

import org.example.orderObject.Order;
import org.example.orderObject.OrderReader;
import org.example.sale.Sale;
import org.example.store.StoreOrders;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new OrderReader("discount_day.txt").read();
        List<Order> discontSort = new Sale(orders, BigDecimal.valueOf(50), BigDecimal.valueOf(5), BigDecimal.valueOf(100)).discount();
        StoreOrders pushFile = new StoreOrders();
        pushFile.storeOrderLine(discontSort);
    }
}