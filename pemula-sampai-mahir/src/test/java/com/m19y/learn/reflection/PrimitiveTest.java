package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrimitiveTest {

  @Test
  void testPrimitive() {

    // by default int (tipe data primitive akan dikonversio ke tipe data object (non primitive)
    Class<Integer> intClass = int.class;
    Class<Boolean> booleanClass = boolean.class;
    Class<Float> floatClass = Float.TYPE;

    System.out.println(intClass.isPrimitive());
    System.out.println(booleanClass.isPrimitive());
    System.out.println(floatClass.isPrimitive());

    System.out.println(intClass.getPackage());
  }

  @Test
  void getField() throws NoSuchFieldException {
    Class<User> userClass = User.class;

    Field age = userClass.getDeclaredField("age");

    System.out.println(age.getType().isPrimitive()); // true ("because age declare as  primitive type")

  }

  @Test
  void getFieldValuePrimitive() throws NoSuchFieldException, IllegalAccessException {

    Class<User> userClass = User.class;

    Field age = userClass.getDeclaredField("age");

    User user = new User("otong", "rahasia", "otong@gmail.com", 19);

    age.setAccessible(true); // harus, because age is private
    System.out.println(age.getInt(user));

    Assertions.assertEquals(user.getAge(), age.getInt(user));

  }

  @Test
  void testGetAgeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Class<User> userClass = User.class;

    Method setAge = userClass.getDeclaredMethod("setAge", int.class);

    User user = new User("otong", "rahasia", "otong@gmail.com", 19);

    setAge.invoke(user, 23);

    Assertions.assertEquals(23,  user.getAge());


  }
}
