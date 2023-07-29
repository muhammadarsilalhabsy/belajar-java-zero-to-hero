package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SupperClassTest {

  @Test
  void getSupperClassTest() {

    Class<Person> person = Person.class;

    Class<? super Person> superclass = person.getSuperclass();

    Class<? super Person> lastSupperClass = superclass.getSuperclass(); // mengembalikan null, jika sudah tidak ada lagi superclass

    Assertions.assertEquals(Object.class, superclass);
    Assertions.assertNull(lastSupperClass);

  }
}
