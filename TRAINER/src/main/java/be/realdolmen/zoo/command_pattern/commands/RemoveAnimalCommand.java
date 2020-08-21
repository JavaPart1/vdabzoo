package be.realdolmen.zoo.command_pattern.commands;

import be.realdolmen.zoo.domain.Animal;
import be.realdolmen.zoo.services.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

// command class which calls the receiver
public class RemoveAnimalCommand implements Command {
    private Logger logger = LoggerFactory.getLogger(FeedAnimalCommand.class.getName());
    private AnimalService animalService = new AnimalService();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Which animal do you want to remove? ");
        List<Animal> animals = animalService.getAnimals();
        animals.forEach(animal -> System.out.println("\t " + animal.getId() + ". name:" + animal.getName() + " Animal_Type:" + animal.getAnimalType()));
        System.out.print("Choose a number: ");
        int animalId = scanner.nextInt();
        Animal animal = animals.stream().filter(a -> a.getId() == animalId).findFirst().get();
        animalService.deleteAnimal(animal);
    }
}
