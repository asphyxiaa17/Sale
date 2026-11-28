package org.example;

import org.example.repository.FileParser;
import org.example.entity.Order;
import org.example.service.OrderParser;
import org.example.service.OrderSummary;
import org.example.service.PromotionManager;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        FileParser reader = new FileParser("discount_day.txt");
        Path output = Paths.get("src/main/resources/finalList/output.txt");
        List<String> file;
        List<Order> orders;
        try {
            file = reader.read();
        } catch (RuntimeException e) {
            System.err.println("Не удалось прочитать файл" + e.getMessage());
            return;
        }
        OrderParser orderParsing = new OrderParser();
        try {
            orders = orderParsing.parsing(file);
        } catch (IllegalArgumentException e) {
            System.err.println("Некоректный формат файла" + e.getMessage());
            return;
        }
        PromotionManager promotion = new PromotionManager(orders, BigDecimal.valueOf(50), BigDecimal.valueOf(5), BigDecimal.valueOf(100));
        List<Order> discountCalculate = promotion.discount();

        try {
            OrderSummary summary = new OrderSummary(output);
            summary.storeOrderLine(discountCalculate);
        } catch (RuntimeException e) {
            System.err.println("Файл не найден" + e.getMessage());
            return;
        }
    }
}