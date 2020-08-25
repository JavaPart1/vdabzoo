package be.realdolmen.zoo.command_pattern.commands.commands;

import be.realdolmen.zoo.domain.Animal;
import be.realdolmen.zoo.domain.Food;
import be.realdolmen.zoo.services.AnimalService;
import be.realdolmen.zoo.services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class FeedAnimalCommand implements Command {
    private AnimalService animalService = new AnimalService();
    private FoodService foodService = new FoodService();
    private Logger logger = LoggerFactory.getLogger(FeedAnimalCommand.class.getName());
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Which animal do you want to feed? ");
        List<Animal> animals = animalService.getAnimals();
        animals.forEach(animal -> System.out.println("\t " + animal.getId() + ". name:" + animal.getName() + " Animal_Type:" + animal.getAnimalType()));
        System.out.print("Choose a number: ");
        int animalId = scanner.nextInt();
        Animal animal = animals.stream().filter(a -> a.getId() == animalId).findFirst().get();

        System.out.println("Which food do you want to feed the animal? ");
        List<Food> foodList = foodService.getFoodNamesByFoodType(animal);
        foodList.forEach(food -> System.out.println("\t" + food.getId() + ". " + food.getFoodName()));
        System.out.print("Choose a number: ");

        int foodId = scanner.nextInt();
        Food food = foodList.stream().filter(f -> f.getId() == foodId).findFirst().get();

        animalService.feedAnimal(animal, food);
        logger.info("Feeding animal successful");
    }
}
