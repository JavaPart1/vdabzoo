package be.realdolmen.zoo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderService {
    private String path;

    public FileReaderService(String path) {
        this.path = path;
    }

    public List<String> readFile() {
        List<String> words = new ArrayList<String>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            words = fileReader.lines().collect(Collectors.toList());
            return words;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
