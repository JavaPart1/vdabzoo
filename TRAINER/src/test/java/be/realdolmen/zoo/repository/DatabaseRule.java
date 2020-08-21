package be.realdolmen.zoo.repository;

import be.realdolmen.zoo.util.Database;
import org.junit.rules.ExternalResource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseRule extends ExternalResource {
    private Connection connection;

    @Override
    protected void before() throws Throwable {
        connection = new Database().createConnection();
    }

    @Override
    protected void after() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
