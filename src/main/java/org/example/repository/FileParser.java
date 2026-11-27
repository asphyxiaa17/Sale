package org.example.repository;

import org.example.api.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileParser implements FileReader {
    private final String fileRoad;

    public FileParser(String fileRoad) {
        this.fileRoad = fileRoad;
    }

    @Override

    public List<String> read() {
        List<String> orderStringList = new ArrayList<>();
            try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileRoad);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    orderStringList.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException ("Не удалось прочитать файл" + fileRoad, e);
            } catch (NullPointerException e) {
                throw new RuntimeException ("Не удалось найти файл" + fileRoad, e);
            }

        return orderStringList;
    }
}

