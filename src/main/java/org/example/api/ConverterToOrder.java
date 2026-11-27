package org.example.api;
import org.example.entity.Order;
import java.util.List;

public interface ConverterToOrder {
    List<Order> parsing(List<String> orderStringList);
}
