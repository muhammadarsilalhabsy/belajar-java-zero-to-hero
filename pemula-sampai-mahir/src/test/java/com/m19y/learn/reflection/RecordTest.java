package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordTest {

  @Test
  void testRecord() {

    Class<Product> productClass = Product.class;


    System.out.println(productClass.isRecord());
    System.out.println(Arrays.toString(productClass.getDeclaredFields()));
    System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
    System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
    System.out.println(Arrays.toString(productClass.getRecordComponents()));

  }

  @Test
  void testGetRecordValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Class<Product> productClass = Product.class;

    Method getName = productClass.getDeclaredMethod("name");

    Product product = new Product("P0001", "Gelas", 2_000L);

    String name = (String) getName.invoke(product);

    System.out.println(name);

    Assertions.assertEquals(product.name(), name);

  }

  @Test
  void testGetRecordValueByComponents() throws InvocationTargetException, IllegalAccessException {

    Class<Product> productClass = Product.class;

    Product product = new Product("P0001", "Gelas", 2_000L);

    RecordComponent[] recordComponents = productClass.getRecordComponents();

    for(RecordComponent component : recordComponents){
      Method accessors  = component.getAccessor();
      System.out.println(accessors.getName()); // id, name, price
      System.out.println(accessors.invoke(product));
    }



  }
}
