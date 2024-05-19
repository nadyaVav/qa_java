package com.example;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

  @Spy
  private Feline feline;

  private List<String> expectedListOfFood;
  private int expectedCountOfKittens;
  private String expectedFamily;

  @Before
  public void setup() {
    expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
    expectedCountOfKittens = 1;
    expectedFamily = "Кошачьи";
  }

  @Test
  public void eatMeat() throws Exception {
    Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfFood);
    List<String> foodList = feline.eatMeat();
    assertEquals(expectedListOfFood, foodList);
    Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
  }

  @Test
  public void getFamily() {
    String result = feline.getFamily();
    assertEquals(expectedFamily, result);
  }

  @Test
  public void getKittensWithoutParams() {
    int result = feline.getKittens();
    assertEquals(expectedCountOfKittens, result);
    Mockito.verify(feline, Mockito.times(1)).getKittens(1);
  }

  @Test
  public void getMoreThenOneKitten() {
    int result = feline.getKittens(2);
    assertEquals(2, result);
  }
}