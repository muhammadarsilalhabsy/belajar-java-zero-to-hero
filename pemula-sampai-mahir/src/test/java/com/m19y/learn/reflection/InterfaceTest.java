package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Nameable;
import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InterfaceTest {

  @Test
  void testInterface() {

    Class<Nameable> nameableClass = Nameable.class;

    System.out.println(nameableClass.getName()); // Namable
    System.out.println(nameableClass.isInterface()); // true
    System.out.println(nameableClass.getSuperclass()); // nothing
    System.out.println(Arrays.toString(nameableClass.getInterfaces())); // []
    System.out.println(Arrays.toString(nameableClass.getDeclaredFields())); // []
    System.out.println(Arrays.toString(nameableClass.getDeclaredConstructors())); // []
    System.out.println(Arrays.toString(nameableClass.getDeclaredMethods())); // length.2


    Assertions.assertEquals("Nameable", nameableClass.getSimpleName()); // Namable
    Assertions.assertTrue(nameableClass.isInterface()); // true
    Assertions.assertNull(nameableClass.getSuperclass()); // nothing
    Assertions.assertEquals(0, nameableClass.getInterfaces().length); // []
    Assertions.assertEquals(0, nameableClass.getDeclaredFields().length); // []
    Assertions.assertEquals(0, nameableClass.getDeclaredConstructors().length); // []
    Assertions.assertEquals(2, nameableClass.getDeclaredMethods().length); // length.2

  }

  @Test
  void getSupperInterfaceFromClass() {

    Class<Person>  personClass = Person.class;

    System.out.println(Arrays.toString(personClass.getInterfaces()));
    Assertions.assertEquals(2, personClass.getInterfaces().length);
  }
}
