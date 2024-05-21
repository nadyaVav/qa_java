package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionExceptionTest {

  private static final String OUT_OF_SEX_LIST_EXCEPTION = "Используйте допустимые значения пола животного - самец или самка";
  private final String sex;

  @Parameterized.Parameters
  public static Object[][] data() {
    return new Object[][] {
      {"unknown"},
      {null},
      {"САМЕЦ"},
      {"САМКА"}
    };
  }

  public LionExceptionTest(String sex) {
    this.sex = sex;
  }

  @Test()
  public void checkException()  {
    Exception exception = Assert.assertThrows(Exception.class, ()-> new Lion(null, sex));
    Assert.assertEquals(OUT_OF_SEX_LIST_EXCEPTION, exception.getMessage());
  }

}
