package be.realdolmen.zoo.domain;

import be.realdolmen.zoo.domain.enums.AnimalType;
import be.realdolmen.zoo.domain.enums.FoodType;

public abstract class Animal extends BaseEntity{
    private Food food;
    private FoodType foodType;
    private AnimalType animalType;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food getFood() {
        return food;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setFood(Food food) {
        this.food = food;
    }

}


// ------ IF YOU WANT TO USE THE BUILDER PATTERN ------
//public abstract class Animal extends BaseEntity{
//    protected Animal(Builder builder) {
//        this.name = builder.name;
////        this.food = builder.food;
//        this.id = builder.id;
//    }
//
//    protected Animal() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
////    public Food getFood() {
////        return food;
////    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public AnimalType getAnimalType() {
//        return animalType;
//    }
//
//public static class Builder {
//    private String name;
//    private Food food;
//    private AnimalType animalType;
//    private int id;
//    private Logger logger = LoggerFactory.getLogger(Animal.class.getName());
//
//    public Builder(AnimalType animalType) {
//        this.animalType = animalType;
//    }
//
//    public Builder withId(int id) {
//        this.id = id;
//        return this;
//    }
//
//    public Builder withFood(Food food) {
//        this.food = food;
//        return this;
//    }
//
//    public Builder withName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public Animal build() {
//        try {
//            switch (this.animalType) {
//                case BEAR:
//                    return new Bear(this);
//                case LION:
//                    return new Lion(this);
//                case DOG:
//                    return new Dog(this);
//                case GIRAFFE:
//                    return new Giraffe(this);
//                default:
//                    throw new ClassNotFoundException(this.animalType + " class does not exist");
//            }
//        } catch (ClassNotFoundException e) {
//            logger.error(this.animalType + " class does not exist", e);
//        }
//        return null;
//    }
//
//
//}
//
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("name:" + name);
////        stringBuilder.append(" food:" + getFood());
//        return stringBuilder.toString();
//    }
//}
