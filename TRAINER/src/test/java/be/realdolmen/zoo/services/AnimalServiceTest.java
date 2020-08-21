package be.realdolmen.zoo.services;

import be.realdolmen.zoo.domain.Animal;
import be.realdolmen.zoo.domain.Bear;
import be.realdolmen.zoo.domain.Food;
import be.realdolmen.zoo.domain.enums.FoodType;
import be.realdolmen.zoo.repository.jdbc.AnimalRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @Captor
    ArgumentCaptor<Animal> animalArgumentCaptor;

    @InjectMocks
    private AnimalService animalService = new AnimalService();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addAnimal() {
//        Animal animal = new Animal.Builder(AnimalType.BEAR)
//                .withId(9).withName("Max").withFood(new Food(1, FoodType.MEAT, "fish")).build();
        Animal animal = new Bear();
        animal.setFood(new Food(1, FoodType.MEAT, "fish"));
        animal.setName("Max");
        animalService.saveAnimal(animal);

        verify(animalRepository).save(animalArgumentCaptor.capture());

        assertEquals("Max",animalArgumentCaptor.getValue().getName());
    }
}
