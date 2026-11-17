package org.example.intr;
import java.util.List;

public interface intrOrderReader {
    public List<String> orderlist();
    public List<String[]> splitStrings(List<String> lines);
}
