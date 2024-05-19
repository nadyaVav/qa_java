package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionSexByManeTest {

  boolean expectedResult;
  String sex;

  @Parameterized.Parameters
  public static Object[][] data() {
    return new Object[][] {
      {"Самец", true},
      {"Самка", false}
    };
  }

  public LionSexByManeTest(String sex, boolean expectedResult) {
    this.sex = sex;
    this.expectedResult = expectedResult;
  }

  @Test
  public void doesHaveMane() throws Exception {
    Feline feline = new Feline();
    Lion lion = new Lion(feline, sex);
    Assert.assertEquals(expectedResult, lion.doesHaveMane());
  }
}
