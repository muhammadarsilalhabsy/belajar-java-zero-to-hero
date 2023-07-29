package com.m19y.learn.unittest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Test Method-method pada calculator class")
class CalculatorTest {

  private Calculator calculator = new Calculator();
  @Test
  void testCalculatorSumSuccess(){
    int result =  calculator.sum(8,9);
    assertEquals(17, result);
  }

  @Test
  void testCalculatorDivideSuccess() {
    float result = calculator.divided(19, 2);
    assertEquals(9.5F, result);
  }

  @Test
  void testCalculatorDivideThrowException() {
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.divided(19, 0);
    });

    // using anonymous class
    /*assertThrows(IllegalArgumentException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        calculator.divided(19, 0);
      }
    });*/
  }

  // menggunakan annotation @DisplayName

  @Test
  @DisplayName("test success multiply")
  void xxxTemplateXxx() {
    assertEquals(35, calculator.multiply(7, 5));
  }

  @Test
  @Disabled
  void commingSoon() {
    // will disable when add annotation @Disable on top of the method
  }
}