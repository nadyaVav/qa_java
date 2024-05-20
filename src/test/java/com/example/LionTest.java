package com.example;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

  List<String> expectedListOfFood;
  Lion lion;
  String sex = "Самец";
  int expectedCountOfKittens;
  @Mock
  Feline feline;

  @Before
  public void setup() throws Exception {
    lion = new Lion(feline, sex);
    expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
    expectedCountOfKittens = 1;
  }

  @Test
  public void getKittens() {
    Mockito.when(feline.getKittens()).thenReturn(1);
    int result = lion.getKittens();
    assertEquals(expectedCountOfKittens, result);
  }

  @Test
  public void foodLionTest() throws Exception {
    Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfFood);
    List<String> result = lion.getFood();
    assertEquals(expectedListOfFood, result);
  }

}