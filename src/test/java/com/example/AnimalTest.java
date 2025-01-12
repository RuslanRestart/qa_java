package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final boolean shouldThrowException;

    public AnimalTest(String animalKind, List<String> expectedFood, boolean shouldThrowException){
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.shouldThrowException= shouldThrowException;
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), false},
                {"Травоядное", List.of("Трава", "Различные растения"), false},
                {"Неизвестно", null, true}
        };
    }

    @Test
    public void testGetFood(){
        Animal animal = new Animal();
        try {
            List<String> actualFood = animal.getFood(animalKind);
            assertEquals(expectedFood, actualFood);
        } catch (Exception e) {
            if (!shouldThrowException){
                throw new RuntimeException("Test failed!", e);
            }
        }
    }
}
