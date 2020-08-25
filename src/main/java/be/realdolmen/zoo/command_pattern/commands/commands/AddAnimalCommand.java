package be.realdolmen.zoo.command_pattern.commands.commands;



import be.realdolmen.zoo.domain.*;
import be.realdolmen.zoo.domain.enums.AnimalType;
import be.realdolmen.zoo.domain.enums.FoodType;
import be.realdolmen.zoo.services.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

// command class which calls the receiver
public class AddAnimalCommand implements Command {
    private AnimalService animalService = new AnimalService();
    private Logger logger = LoggerFactory.getLogger(AddAnimalCommand.class.getName());
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        try {
            System.out.println("Which type? ");
            Arrays.stream(AnimalType.values()).forEach(animalType -> {
                System.out.printf("\t%d. %s \n",animalType.ordinal(),animalType.getName());
            });
            System.out.print("Choose a number: ");
            int type = scanner.nextInt();

//        Animal animal = new Animal(AnimalType.values()[type]).withName(name).build(); // TROUBLE without a builder pattern
            Animal animal = null;
            switch (AnimalType.values()[type]) {
                case BEAR:
                    animal = new Bear();
                    animal.setFoodType(FoodType.FISH);
                    break;
                case LION:
                    animal = new Lion();
                    animal.setFoodType(FoodType.MEAT);
                    break;
                case DOG:
                    animal = new Dog();
                    animal.setFoodType(FoodType.MEAT);
                    break;
                case GIRAFFE:
                    animal = new Giraffe();
                    animal.setFoodType(FoodType.VEGGIE);
                    break;
                default:
                    try {
                        throw new ClassNotFoundException(type + " class does not exist");
                    } catch (ClassNotFoundException e) {
                        logger.error(e.getMessage());
                    }
            }
            animal.setAnimalType(AnimalType.values()[type]);
            System.out.print("What is the name?: ");
            String name = scanner.next();

            animal.setName(name);

            animalService.saveAnimal(animal);
            logger.info("Adding animal successful");
        } catch (InputMismatchException e) {
            logger.warn("Give in a correct number");
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                logger.error("Something went wrong try again", e);
            }
            scanner.next();
            execute();
        }
    }
}
