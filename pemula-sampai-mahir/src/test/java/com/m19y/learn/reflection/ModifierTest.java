package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class ModifierTest {

  @Test
  void testModifier() {

    Class<Person> personClass = Person.class;


    System.out.println(Modifier.isPublic(personClass.getModifiers()));
    System.out.println(Modifier.isFinal(personClass.getModifiers()));
    System.out.println(Modifier.isPrivate(personClass.getModifiers()));

    Assertions.assertTrue(Modifier.isPublic(personClass.getModifiers()));
    Assertions.assertFalse(Modifier.isFinal(personClass.getModifiers()));
    Assertions.assertFalse(Modifier.isPrivate(personClass.getModifiers()));
  }
}
