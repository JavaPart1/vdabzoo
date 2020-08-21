package be.realdolmen.collections;


import be.realdolmen.zoo.services.FileReaderService;

import java.util.Collections;
import java.util.Scanner;

public class Oef20_1 {
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new Oef20_1().start();
    }

    private void start() {
        System.out.println("give path to file of press '.' to get the default file TRAINER/RandomText.txt");
        String path = scanner.next();
        if(path.equals(".")){
            path = "TRAINER/RandomText.txt";
        }
        FileReaderService fileReaderService = new FileReaderService(path);
        fileReaderService.readFile().stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
