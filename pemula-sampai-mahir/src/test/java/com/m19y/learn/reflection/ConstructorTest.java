package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {

  private Class<Person> personClass = Person.class;

  @Test
  void testGetConstructor() {

    // get all constructor
    Constructor<?>[] constructors = personClass.getConstructors();

    for (Constructor<?> constructor: constructors){
      System.out.println(constructor.getName());
      System.out.println(Arrays.toString(constructor.getParameterTypes()));
      System.out.println("--------------------");
    }

  }

  @Test
  void testCreateObjectUsingConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    Constructor<Person> emptyConstructor = personClass.getConstructor();
    Constructor<Person> constructorWith1Param = personClass.getConstructor(String.class);
    Constructor<Person> constructorWith3Param = personClass.getConstructor(String.class, String.class, Integer.TYPE);

    Person emptyPerson = emptyConstructor.newInstance();
    Person personWithFirstname = constructorWith1Param.newInstance("Jamal");
    Person personWithDetail = constructorWith3Param.newInstance("Barumbung", "Si tumorang", 43);

    Assertions.assertNull(emptyPerson.getFirstname());
    Assertions.assertEquals("Jamal", personWithFirstname.getFirstname());
    Assertions.assertEquals("Barumbung", personWithDetail.getFirstname());
    Assertions.assertEquals("Si tumorang", personWithDetail.getLastname());
    Assertions.assertEquals(43, personWithDetail.getAge());


  }
}
