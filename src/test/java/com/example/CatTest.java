package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline felineMock;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(felineMock);
        String meowSound = cat.getSound();
        assertEquals("Мяу", meowSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> catFood = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), catFood);
        Mockito.verify(felineMock, Mockito.times(1)).eatMeat();
    }
}