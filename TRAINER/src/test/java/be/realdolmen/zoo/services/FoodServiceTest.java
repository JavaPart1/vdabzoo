package be.realdolmen.zoo.services;

import be.realdolmen.zoo.domain.Food;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FoodServiceTest {

   private FoodService foodService = new FoodService();

    @Test
    public void getAllFoodtypesTest() {
        List<Food> allFood = foodService.getAllFood();
        Assert.assertFalse(allFood.isEmpty());
    }



}
