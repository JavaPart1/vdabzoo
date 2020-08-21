package be.realdolmen.zoo.services;


import be.realdolmen.zoo.domain.Animal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriterService {

    private String path;

    public FileWriterService(String path) {
        this.path = path;
    }

    public void writeToFile(List<Animal> animals) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.path)))) {
            for (Animal animal : animals) {
                printWriter.printf("id: %d ,name: %s \n", animal.getId(), animal.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
