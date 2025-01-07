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
    public void getKittensTest() {
        try {
            Lion lion = new Lion("Самка", felineMock);
            Mockito.when(felineMock.getKittens()).thenReturn(1);
            int countKittens = lion.getKittens();
            assertEquals(1, countKittens);
            Mockito.verify(felineMock, Mockito.times(1)).getKittens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void maleHaveManeTest() {
        try {
            Lion lion = new Lion("Самец", felineMock);
            boolean hasMane = lion.doesHaveMane();
            assertEquals(true, hasMane);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void femaleNotHaveManeTest(){
        try {
            Lion lion = new Lion("Самка", felineMock);
            boolean hasMane = lion.doesHaveMane();
            assertEquals(false, hasMane);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getLionFoodTest() {
        try {
            Lion lion = new Lion("Самец", felineMock);
            Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> actualFood = lion.getFood();
            assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
            Mockito.verify(felineMock, Mockito.times(1)).getFood("Хищник");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}