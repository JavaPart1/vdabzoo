package be.realdolmen.zoo.services;


import be.realdolmen.zoo.domain.Animal;
import be.realdolmen.zoo.domain.Food;
import be.realdolmen.zoo.repository.jdbc.FoodRepository;

import java.util.List;

public class FoodService {
    private final FoodRepository foodRepository = new FoodRepository();

    public List<Food> getFoodNamesByFoodType(Animal animal) {
//        try {
//            Class cls = Class.forName(animal.getClass().getName());
//            Method method = cls.getMethod("getFoodType");
//            FoodType foodType = (FoodType) method.invoke(animal);
//            return foodRepository.getFoodByType(foodType);
//        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
        return foodRepository.getFoodByType(animal.getFoodType());
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
