package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Data;
import org.junit.jupiter.api.Test;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class TypeVariableTest {

  @Test
  void testGetTypeVariable() {

    Class<Data> dataClass = Data.class;

    System.out.println(Arrays.toString(dataClass.getTypeParameters()));
    TypeVariable<Class<Data>>[] typeParameters = dataClass.getTypeParameters();

    for( TypeVariable<Class<Data>> parameter : typeParameters){
      System.out.println(Arrays.toString(parameter.getBounds()));
      System.out.println(parameter.getName());
      System.out.println(parameter.getGenericDeclaration());
    }


  }
}
