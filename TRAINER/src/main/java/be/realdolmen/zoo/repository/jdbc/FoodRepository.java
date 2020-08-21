package be.realdolmen.zoo.repository.jdbc;


import be.realdolmen.zoo.util.Database;
import be.realdolmen.zoo.domain.Food;
import be.realdolmen.zoo.domain.enums.FoodType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodRepository {

    private Food processFood(ResultSet resultSet) throws SQLException {
        return new Food(resultSet.getInt("id")
                , FoodType.valueOf(resultSet.getString("type"))
                , resultSet.getString("name"));
    }

    public List<Food> getFoodByType(FoodType foodType) {
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement(("select * from Food where type like ? "))) {
            preparedStatement.setString(1, foodType.name());
            preparedStatement.execute();
            List<Food> foodList = new ArrayList<Food>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                foodList.add(processFood(resultSet));
            }
            return foodList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Food> findAll() {
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement(("select * from Food"))) {
            preparedStatement.execute();
            List<Food> foodList = new ArrayList<Food>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                foodList.add(processFood(resultSet));
            }
            return foodList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
