package org.example.orderObject;

import org.example.intr.intrOrderReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderReader implements intrOrderReader {
    private final String fileRoad;

    public OrderReader(String fileRoad) {
        this.fileRoad = fileRoad;
    }
    @Override

    public List<Order> read() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        List<Order> orders = new ArrayList<>();
        List<String> orderList = new ArrayList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileRoad);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orderList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл" + e.getMessage());
        }
        for (String orderlin : orderList) {
            String[] pars = orderlin.split("\\|");
            LocalDateTime ordData = LocalDateTime.parse(pars[0], formatter);
            String shopName = pars[1];
            int wheitKg = Integer.parseInt(pars[2]);
            orders.add(new Order(ordData, shopName, wheitKg));
        }
        return orders;
    }
}

