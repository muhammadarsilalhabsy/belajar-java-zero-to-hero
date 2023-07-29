package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

  @Test
  void testGetMethod() {

    // setup class
    Class<Person> personClass = Person.class;

    // ambil semua method yang ada di class person
    Method[] exsistMethod = personClass.getDeclaredMethods();

    for(Method method :  exsistMethod){
      System.out.println(method.getName()); // nama method
      System.out.println(Arrays.toString(method.getExceptionTypes())); // extension yang ada di methodnya
      System.out.println(Arrays.toString(method.getParameterTypes())); // semua parameter yang ada di dalam method
      System.out.println("-----------------------");
    }
  }


  @Test
  void testGetMethodValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Class<Person> personClass = Person.class;

    // ambil salah satu method (casenya tanpa parameter dulu) -> menggunakan parameter lihat di ParameterTest
    // ! bisa throw exception
    Method methodGetAge = personClass.getMethod("getAge");

    Person ucok = new Person("Ucok", "cok", 17);

    // ! bisa throw exception
    Integer returnValueFromMethodGetAge = (Integer) methodGetAge.invoke(ucok); // sama seperti ucok.getAge();

    Assertions.assertEquals(17, returnValueFromMethodGetAge);
    Assertions.assertEquals(ucok.getAge(), returnValueFromMethodGetAge);



  }
}
