package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ClassTest {

  @Test
  void testGetClass() throws ClassNotFoundException {

    // cara mendapatkan class, interface ataupun enum menggunakan reflection

    // cara 1 (java.lang.Class)
    Class<Person> person1 = Person.class;

    // cara 2 (wildcard) ! bisa throw exception (ClassNotFoudException)
    Class<?> person2 = Class.forName("com.m19y.learn.reflection.data.Person");

    // cara 3 (menggunakan Object yang sudah ada)
    Person person = new Person("Arsil");
    Class<? extends Person> person3 = person.getClass();


    // test kalau person 1 - 3 harus sama dengan class Person yang ada di reflection
    assertEquals(person1, Person.class);
    assertEquals(person2, Person.class);
    assertEquals(person3, Person.class);

  }

  @Test
  void testClassMethod(){

    Class<Person> person = Person.class;

    System.out.println(person.getClass()); // Class<>
    System.out.println(person.getSuperclass()); // Object
    System.out.println(person.getSimpleName()); // Person
    System.out.println(person.getModifiers());
    System.out.println(person.getPackage()); // com.m19y.learn.reflection
    System.out.println(person.getPackageName()); // com.m19y.learn.reflection
    System.out.println(Arrays.toString(person.getFields())); // return seluruh fields public
    System.out.println(Arrays.toString(person.getDeclaredFields())); // return seluruh fields tanpa terkecuali
    System.out.println(Arrays.toString(person.getMethods())); // return seluruh method public
    System.out.println(Arrays.toString(person.getDeclaredMethods())); // return seluruh method tanpa terkecuali
    System.out.println(Arrays.toString(person.getConstructors())); // return seluruh constructor public
    System.out.println(Arrays.toString(person.getDeclaredConstructors())); // return seluruh constructor tanpa terkecuali



  }
}
