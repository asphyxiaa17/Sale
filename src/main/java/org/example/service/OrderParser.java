package org.example.service;

import org.example.api.FileCollector;
import org.example.entity.Order;
import org.example.api.ConverterToOrder;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderParser implements ConverterToOrder {

    @Override

    public List<Order> parsing (List<String> orderStringList) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        List<Order> orders = new ArrayList<>();
        for (String orderline : orderStringList) {
            String[] pars = orderline.split("#|\\|");
            if (pars.length < 3) {
                throw new RuntimeException("Некорректный формат файла: Недостаточно строк" + orderline);
            }
                LocalDateTime orderData = LocalDateTime.parse(pars[0], formatter);
                String shopName = pars[1];
                BigDecimal weightKg = new BigDecimal(pars[2]);
                orders.add(new Order(orderData, shopName, weightKg));
        }
        return orders;
    }
}