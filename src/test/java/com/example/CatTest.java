package com.example;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

  private List<String> expectedListOfFood;
  Cat cat;
  @Mock
  Feline feline;

  @Before
  public void setup() {
    cat = new Cat(feline);
    expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
  }

  @Test
  public void foodCatTest() throws Exception {
    Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);
    List<String> foodCat = cat.getFood();
    assertEquals(expectedListOfFood, foodCat);
  }

  @Test
  public void shouldReturnCorrectSound() {
    Assert.assertEquals("Мяу", cat.getSound());
  }


}