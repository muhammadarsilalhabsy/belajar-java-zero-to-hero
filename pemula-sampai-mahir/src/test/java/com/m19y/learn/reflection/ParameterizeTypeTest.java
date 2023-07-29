package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ParameterizeTypeTest {

  @Test
  void getMethodGenericTest() throws NoSuchMethodException {

    Class<User> personClass = User.class;

    Method getHobbies = personClass.getDeclaredMethod("getHobbies");

    System.out.println(getHobbies.getReturnType());
    System.out.println(getHobbies.getGenericReturnType());

    Type type = getHobbies.getGenericReturnType();
    System.out.println(type.getClass());

    if (type instanceof ParameterizedType parameterizedType) {

      System.out.println(parameterizedType.getTypeName());
      System.out.println(parameterizedType.getOwnerType());
      System.out.println(parameterizedType.getRawType());
      System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
    }
  }

  @Test
  void getMethodWithParameterGenericTest() throws NoSuchMethodException {

    Class<User> personClass = User.class;

    Method setHobbies = personClass.getDeclaredMethod("setHobbies", List.class);

    System.out.println(setHobbies.getReturnType()); // void
    System.out.println(setHobbies.getGenericReturnType());

    Type[] types = setHobbies.getGenericParameterTypes();
    System.out.println(types.getClass());
    for (Type type : types) {

      if (type instanceof ParameterizedType parameterizedType) {

        System.out.println(parameterizedType.getTypeName());
        System.out.println(parameterizedType.getOwnerType());
        System.out.println(parameterizedType.getRawType());
        System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
      }
    }
  }

  @Test
  void fieldGenericTest() throws NoSuchMethodException, NoSuchFieldException {

    Class<User> personClass = User.class;

    Field hobbies = personClass.getDeclaredField("hobbies");

    hobbies.setAccessible(true);

    Type genericType = hobbies.getGenericType();
    System.out.println(genericType.getClass());

    if (genericType instanceof ParameterizedType parameterizedType) {

      System.out.println(parameterizedType.getTypeName());
      System.out.println(parameterizedType.getOwnerType());
      System.out.println(parameterizedType.getRawType());
      System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
    }

  }
}
