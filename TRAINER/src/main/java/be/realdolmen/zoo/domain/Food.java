package be.realdolmen.zoo.domain;


import be.realdolmen.zoo.domain.enums.FoodType;

public class Food extends BaseEntity{
    private FoodType foodType;
    private String foodName;

    public Food(int id, FoodType foodType, String foodName) {
        this.setId(id);
        this.foodType = foodType;
        this.foodName = foodName;
    }

    public Food() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return getFoodName();
    }
}
