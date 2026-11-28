package org.example.service;

import org.example.entity.Order;
import org.example.api.ConverterToOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class OrderParser implements ConverterToOrder {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public List<Order> parsing(List<String> orderStringList) {
        List<Order> orders = new ArrayList<>();
        for (String orderline : orderStringList) {
            String[] pars = orderline.split("#|\\|");
            if (pars.length < 3) {
                throw new IllegalArgumentException("Некорректный формат файла: Недостаточно строк" + orderline);
            }
            LocalDateTime orderData = LocalDateTime.parse(pars[0], FORMATTER);
            String shopName = pars[1];
            BigDecimal weightKg = new BigDecimal(pars[2]);
            orders.add(new Order(orderData, shopName, weightKg));
        }
        return orders;
    }
}