package org.example.store;

import org.example.intr.intrStoreOrders;
import org.example.orderObject.Order;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreOrders implements intrStoreOrders {

    @Override

    public void storeOrderLine(List<Order> orderDateDesc) {
        List<String> finalList = new ArrayList<>();
        Map<String, BigDecimal> storeOrders = new HashMap<String, BigDecimal>();
        for (Order order : orderDateDesc) {
            storeOrders.merge(order.getShopName(), order.getFinlePrice(), BigDecimal::add);
        }
        storeOrders.forEach((shop, sum) -> {
            String row = shop + " - " + sum;
            finalList.add(row);
        });
        Path path = Paths.get("src/main/resources/finalList/output.txt");
        try {
            Files.write(path, finalList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Файл для записи не найден" + e.getMessage());
        }
    }
}
