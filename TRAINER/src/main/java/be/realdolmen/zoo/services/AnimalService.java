package be.realdolmen.zoo.services;


import be.realdolmen.zoo.domain.Animal;
import be.realdolmen.zoo.domain.Food;
import be.realdolmen.zoo.exceptions.NotFoundException;
import be.realdolmen.zoo.repository.jdbc.AnimalRepository;

import java.util.List;

public class AnimalService {
    private AnimalRepository animalRepository = new AnimalRepository();

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }


    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }


    public void deleteAnimal(Animal animal) {
        animalRepository.delete(animal);
    }

    public void feedAnimal(Animal animal, Food food) {
        animal.setFood(food);
        animalRepository.update(animal);
    }
}
