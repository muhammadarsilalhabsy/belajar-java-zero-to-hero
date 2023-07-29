package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {

  @Test
  void testArray() {

    Class<String[]> stringArrayClass = String[].class;
    Class<int[]> intArrayClass = int[].class;
    Class<Person> personClass = Person.class;

    assertTrue(stringArrayClass.isArray());
    assertTrue(intArrayClass.isArray());
    assertFalse(personClass.isArray());
  }

  @Test
  void testArrayMember() {

    Class<String[]> stringArrayClass = String[].class;
    Class<String[][]> stringMulArrayClass = String[][].class;
    Class<int[][]> intMulArrayClass = int[][].class;

    System.out.println(Arrays.toString(stringArrayClass.getDeclaredFields())); // []
    System.out.println(Arrays.toString(stringArrayClass.getDeclaredMethods())); // []

    // dapatkan tipe data didalamnya
    System.out.println(stringArrayClass.getComponentType()); // string
    System.out.println(stringMulArrayClass.getComponentType()); // string
    System.out.println(intMulArrayClass.getComponentType());
  }

  @Test
  void testArrayManipulation() {

    // dapatkan classnya
    Class<String[]> stringArrayClass = String[].class;

    // buat instance arraynya
    String[] arrayOfString = (String[]) Array.newInstance(stringArrayClass.getComponentType(), 5);

    // set arraynya
    Array.set(arrayOfString, 0, "Ajib");
    Array.set(arrayOfString, 1, "Otong");
    Array.set(arrayOfString, 2, "Jamal");
    Array.set(arrayOfString, 3, "Saharudin");

    // get arraynya

    for(int i = 0; i < arrayOfString.length; i++){
    System.out.println(Array.get(arrayOfString, i));
    }

    Assertions.assertEquals("Ajib", Array.get(arrayOfString, 0));
    Assertions.assertEquals("Otong", Array.get(arrayOfString, 1));
    Assertions.assertEquals("Jamal", Array.get(arrayOfString, 2));
    Assertions.assertEquals("Saharudin", Array.get(arrayOfString, 3));
    Assertions.assertNull(Array.get(arrayOfString, 4));



  }
}
