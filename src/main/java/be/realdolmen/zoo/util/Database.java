package be.realdolmen.zoo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Logger logger = LoggerFactory.getLogger(Database.class);
//    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zooPu");
//    private static EntityManager entityManager;

    public Connection createConnection() throws SQLException {
        try {
            Class.forName(Helper.loadPropertiesFile().getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            logger.error("Error mysql driver:", e);
        }
        return DriverManager.getConnection(Helper.loadPropertiesFile().getProperty("db.url")
                , Helper.loadPropertiesFile().getProperty("db.username")
                , Helper.loadPropertiesFile().getProperty("db.password"));
    }

//    public static EntityManager getEntityManager() {
//        // i've refactored the getEntityManager in the Database Class
//        // because i found out that the entitymanager can still hold old data
//        // now with this we create a new EntityManager every time we call this method and also close it first when it's open
//        // this is already being solved with the spring framework
//        if (entityManager != null && entityManager.isOpen()) {
//            entityManager.close();
//            logger.info("Closing EntityManager");
//        }
//        logger.info("Creating EntityManager");
//        entityManager = entityManagerFactory.createEntityManager();
//        return entityManager;
//    }


}

