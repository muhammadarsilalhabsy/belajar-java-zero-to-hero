package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {

  @Test
  void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {

    Person otong = new Person("Otong", "surotong", 20);

    // ambil classnya
    Class<Person> person = Person.class;

    // ambil fiedlsnya (menggunakan array)
    Field[] fields = person.getDeclaredFields();

    // ambil fiedlnya (bisa throw error)
    Field fieldFirstName = person.getDeclaredField("firstname");

    // cara conventional menggambil value dari field object Person
    String firstname = otong.getFirstname();

    // dikarenakan fieldnya 'private' kita harus berukan accessible
    fieldFirstName.setAccessible(true);
    fields[0].setAccessible(true);

    // cara menggunakan reflection mengambil value dari field object Person
     String reflectionFirstname1 = (String) fields[0].get(otong); // mengambil dengan array
    String reflectionFirstname2 = (String) fieldFirstName.get(otong); // mengambil tanpa array

    assertEquals("Otong",firstname);
    assertEquals("Otong",reflectionFirstname1);
    assertEquals("Otong",reflectionFirstname2);

  }

  @Test
  void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {

    Class<Person> personClass = Person.class;

    Person otong = new Person("Otong", "Surotong", 19);
    Person jamal  = new Person("Jamal", "ludin", 25);

    // get field
    Field getLastName = personClass.getDeclaredField("lastname");

    // ubah access modifiernya
    getLastName.setAccessible(true);

    // ubah value dari fieldnya
    getLastName.set(otong, "Supranto"); // sama dengan => otong.setName(Supranto);
    getLastName.set(jamal, "Saepudin");

    assertEquals("Supranto", otong.getLastname());
    assertEquals("Saepudin", jamal.getLastname());
  }

  @Test
  void testField() {

    // pertama ambil classnya
    Class<Person> person = Person.class;

    // kedua ambil seluruh field, baik itu public private dll
    Field[] declaredFields = person.getDeclaredFields(); // akan mengembalikan array of Fields

    // looping seluruh field didalamnya
    for (Field field: declaredFields){
      System.out.println(field.getName()); // nama fieldnya
      System.out.println(field.getType()); // tipe data yang diggunakan ! dikonfersi jadi object kalau dia primitf
      System.out.println(field.getModifiers()); // mendapatkan akses modifernya
      System.out.println("----------------------");
    }

















  }


}
