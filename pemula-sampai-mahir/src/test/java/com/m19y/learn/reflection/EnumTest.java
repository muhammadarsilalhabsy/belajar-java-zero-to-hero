package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Gender;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EnumTest {


  @Test
  void testEnum() {

    Class<Gender> genderClass  = Gender.class;

    System.out.println(genderClass.isEnum()); // true
    System.out.println(genderClass.getSuperclass());
    System.out.println(Arrays.toString(genderClass.getDeclaredFields())); // 2
    System.out.println(Arrays.toString(genderClass.getDeclaredConstructors())); // 1
    System.out.println(Arrays.toString(genderClass.getEnumConstants())); // 2
    System.out.println(Arrays.toString(genderClass.getDeclaredMethods()));


  }
}
