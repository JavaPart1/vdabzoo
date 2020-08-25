package be.realdolmen.zoo.repository;

import be.realdolmen.zoo.domain.Animal;
import be.realdolmen.zoo.repository.jdbc.AnimalRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AnimalRepositoryTest {
    private AnimalRepository animalRepository = new AnimalRepository();
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();
    @Rule
    public FileWriterRule fileWriterRule = new FileWriterRule();
    @Rule
    public Timeout timeoutRule = new Timeout(5000, TimeUnit.MILLISECONDS);


    @Test
    public void assertImplementationGetAnimalsWithDatabase() throws SQLException {
        List<Animal> animals = animalRepository.findAll();
        assertFalse(animals.isEmpty());

        PreparedStatement preparedStatement = databaseRule.getConnection().prepareStatement("select * from Animal", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();
        resultSet.last();

        assertEquals(animals.size(), resultSet.getRow());
    }

    @Test
    public void timeoutTest() throws InterruptedException { //example for the timeout rule
      //  sleep(1000000); // just a small trick to let this test run a long time. Not a real implementation.
    }


    @Test
    public void fileWriterTest() {
        fileWriterRule.getFileWriterService().writeToFile(animalRepository.findAll());
        Assert.assertTrue(Files.exists(Paths.get("./test.txt")));
    }
}
