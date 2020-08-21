package be.realdolmen.zoo.util;

import org.dbunit.JdbcDatabaseTester;

public class TestDatabase extends Database {

    public JdbcDatabaseTester createIDatabaseTesterConnection() throws ClassNotFoundException {
        return new JdbcDatabaseTester(Helper.loadPropertiesFile().getProperty("db.driver")
                , Helper.loadPropertiesFile().getProperty("db.url")
                , Helper.loadPropertiesFile().getProperty("db.username")
                , Helper.loadPropertiesFile().getProperty("db.password"));
    }
}
