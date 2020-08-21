package be.realdolmen.zoo.repository.jdbc;


import be.realdolmen.zoo.exceptions.NotFoundException;
import be.realdolmen.zoo.util.Database;
import be.realdolmen.zoo.domain.*;
import be.realdolmen.zoo.domain.enums.AnimalType;
import be.realdolmen.zoo.domain.enums.FoodType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalRepository {

    public List<Animal> findAll() { // READ
        ArrayList<Animal> animals = new ArrayList<>();
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement("select a.id, a.name, a.type, a.foodType, f.id as foodId, f.name as foodName from Animal as a LEFT OUTER JOIN Food as f ON f.id = a.foodId;")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
//                Animal.Builder animal = new Animal.Builder(AnimalType.valueOf(resultSet.getString("type")))
//                        .withId(resultSet.getInt("id"))
//                        .withName(resultSet.getString("name"));
                Animal animal = null;
                switch (AnimalType.valueOf(resultSet.getString("type"))) { //Easier with builder pattern
                    case BEAR:
                        animal = new Bear();
                        break;
                    case LION:
                        animal = new Lion();
                        break;
                    case DOG:
                        animal = new Dog();
                        break;
                    case GIRAFFE:
                        animal = new Giraffe();
                        break;
                    default:
                        throw new ClassNotFoundException(AnimalType.valueOf(resultSet.getString("type")) + " class does not exist");
                }
                animal.setAnimalType(AnimalType.valueOf(resultSet.getString("type")));
                animal.setName(resultSet.getString("name"));
                animal.setFoodType(FoodType.valueOf(resultSet.getString("foodType")));
                animal.setId(resultSet.getInt("id"));
                if (resultSet.getInt("foodId") != 0) {
                    Food food = new Food(resultSet.getInt("foodId")
                            , FoodType.valueOf(resultSet.getString("foodType"))
                            , resultSet.getString("foodName"));
                    animal.setFood(food);// animal has been fed
                }
                animals.add(animal);
            }
            return animals;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    public void save(Animal animal) { // CREATE
        try (Connection connection = new Database().createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(("insert into Animal values ((SELECT LAST_INSERT_ID()),?,?,?,?)"));) {
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getAnimalType().name());
            if (animal.getFood() == null) {
                preparedStatement.setNull(3, Types.INTEGER);
            } else {
                preparedStatement.setInt(3, animal.getFood().getId());
            }
            preparedStatement.setString(4, animal.getFoodType().name());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Animal animal) { // UPDATE
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement(("update Animal set name=? , type=?, foodId=? where id=?"))) {
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getAnimalType().name());
            preparedStatement.setInt(3, animal.getFood().getId());
            preparedStatement.setInt(4, animal.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Animal animal) { // DELETE
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement(("delete from Animal where id=?"))) {
            preparedStatement.setInt(1, animal.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
