package org.example.api;
import org.example.entity.Order;
import java.util.List;

public interface DiscountCalculator {
    public List<Order> discount();
}
