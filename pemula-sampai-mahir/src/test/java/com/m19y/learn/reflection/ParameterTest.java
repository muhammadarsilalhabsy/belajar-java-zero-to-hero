package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {

  private Class<Person> personClass = Person.class;
  @Test
  void testGetParameterFromMethod() {

    Method[] methods = personClass.getDeclaredMethods();

    for(Method method: methods){
      System.out.println(method.getName());
      Parameter[] parameterFromThisMethod = method.getParameters();

      // loop seluruh parameter yang ada
      for (Parameter parameter : parameterFromThisMethod){
        System.out.println("Parameter Name: " + parameter.getName());
        System.out.println("Parameter Type: " + parameter.getType());

      }
      System.out.println("-----------------------------");
    }

  }


  @Test
  void testSetMethodValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    // ambil methodnya, pastikan dengan parameternya (dikarenakan kemungkinan method overloading)
    Method methodSetFirstName = personClass.getDeclaredMethod("setFirstname", String.class);

    Person otong = new Person("otong", "surotong", 19);

    methodSetFirstName.invoke(otong, "Tong");

    // otong.getFirstname harus sama dengan value yang di set dari methodSetFirstName
    Assertions.assertEquals("Tong", otong.getFirstname());


  }
}
