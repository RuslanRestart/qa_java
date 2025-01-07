package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatTest() {
        try {
            List<String> actualFood = feline.eatMeat();
            assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void getFamilyTest() {
        String felineFamily = feline.getFamily();
        assertEquals("Кошачьи", felineFamily);
    }

    @Test
    public void getKittensWithoutArgumentsTest() {
        int countKittens = feline.getKittens();
        assertEquals(1, countKittens);
    }

    @Test
    public void getKittensWithArgumentsTest() {
        int countKittens = feline.getKittens(3);
        assertEquals(3, countKittens);
    }
}