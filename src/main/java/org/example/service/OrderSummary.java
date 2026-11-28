package org.example.service;

import org.example.api.FileCollector;
import org.example.entity.Order;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderSummary implements FileCollector {
    private final Path path;
    private static final String SEPARATOR = " - ";

    public OrderSummary(Path path) {
        this.path = path;
    }

    @Override
    public void storeOrderLine(List<Order> orderDateDesc) {
        List<String> finalList = new ArrayList<>();
        Map<String, BigDecimal> storeOrders = new HashMap<String, BigDecimal>();
        for (Order order : orderDateDesc) {
            storeOrders.merge(order.getShopName(), order.getFinalPrice(), BigDecimal::add);
        }
        storeOrders.forEach((shop, sum) -> {
            String finalStringLine = shop + SEPARATOR + sum;
            finalList.add(finalStringLine);
        });
        try {
            Files.write(path, finalList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Файл не найден" + path, e);
        }
    }
}