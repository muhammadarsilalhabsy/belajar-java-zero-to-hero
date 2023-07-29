package com.m19y.learn.unittest;

public class Calculator {
  
  public Integer sum(int a, int b){
    return a + b;
  }

  public Float divided(float first, float second){
    if(second == 0){
      throw new IllegalArgumentException("Cannot divide by zero");
    }else{
      return  first / second;
    }
  }

  public Integer multiply(int a, int b){
    return a * b;
  }
}
