package be.realdolmen.zoo.command_pattern.commands.commands;

import be.realdolmen.zoo.domain.Animal;
import be.realdolmen.zoo.services.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// command class which calls the receiver
public class ShowAnimalCommand implements Command {
    private AnimalService animalService = new AnimalService();
    private static Logger logger = LoggerFactory.getLogger(ShowAnimalCommand.class.getName());

    @Override
    public void execute() {
        System.out.println("Showing animals ... please wait");
        List<Animal> animals = animalService.getAnimals();
        animals.forEach(animal -> {
            String foodName = animal.getFood() != null ? animal.getFood().getFoodName() : null;
            System.out.printf("name: %s ,type: %s ,food: %s\n", animal.getName(), animal.getAnimalType(), foodName);
        });
    }
}
