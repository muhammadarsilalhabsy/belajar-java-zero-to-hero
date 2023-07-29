package com.m19y.learn.unittest.generator;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class SimpleDisplayNameGenerator implements DisplayNameGenerator {
  @Override
  public String generateDisplayNameForClass(Class<?> aClass) {
    return "Test Class ->" + aClass.getSimpleName() ;
  }


  @Override
  public String generateDisplayNameForMethod(Class<?> aClass, Method method) {
    return "Test Method -> " + method.getName() + " from Class " + aClass.getSimpleName();
  }

  @Override
  public String generateDisplayNameForNestedClass(Class<?> aClass) {
    return null;
  }
}
