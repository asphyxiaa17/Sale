package org.example.orderObject;
import org.example.intr.intrOrderReader;
import org.example.intr.intrSplitString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Order implements intrOrderReader, intrSplitString {
    private final Path path = Path.of("src/main/resources/discount_day.txt");

    @Override

    public List<String> orderlist() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл" + e.getMessage());
        }
        return lines;
    }

    @Override

    public List<String[]> splitStrings(List<String> lines){
        List<String[]> spliting = lines.stream()
                .map(T -> T.split("\\|"))
                .toList();
        return spliting;
    }
}
