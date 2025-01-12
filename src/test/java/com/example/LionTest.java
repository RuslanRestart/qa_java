package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline felineMock;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int countKittens = lion.getKittens();
        assertEquals(1, countKittens);
    }

    @Test
    public void lionIncorrectSexConstructorTest() {
        try {
            new Lion("Undefined", felineMock);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    @Test
    public void maleHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        boolean hasMane = lion.doesHaveMane();
        assertEquals(true, hasMane);
    }

    @Test
    public void femaleNotHaveManeTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        boolean hasMane = lion.doesHaveMane();
        assertEquals(false, hasMane);
    }

    @Test
    public void getLionFoodTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }
}