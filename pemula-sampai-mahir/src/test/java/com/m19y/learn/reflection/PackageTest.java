package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageTest {

  @Test
  void testPackage() {

    Class<Person> personClass = Person.class;

    Package aPackage =  personClass.getPackage();

    System.out.println(aPackage.getName());
    System.out.println(Arrays.toString(aPackage.getAnnotations()));

    assertEquals("com.m19y.learn.reflection", aPackage.getName());
    assertEquals("com.m19y.learn.reflection", personClass.getPackageName());
    assertEquals(1, aPackage.getAnnotations().length);
  }
}
