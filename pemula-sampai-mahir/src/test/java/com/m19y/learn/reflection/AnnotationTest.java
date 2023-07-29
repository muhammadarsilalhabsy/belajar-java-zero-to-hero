package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.User;
import com.m19y.learn.reflection.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnnotationTest {

  @Test
  void testAnnotationNotBlackSuccess() throws IllegalAccessException {

    User user = new User("otong", "rahasia");

    Validator.validateNotBlank(user);

  }

  @Test
  void testAnnotationNotBlackThrowException() throws IllegalAccessException {

    User user = new User("otong", "  ");

    RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> {

      Validator.validateNotBlank(user);
    });

    Assertions.assertEquals("password must not blank!", runtimeException.getMessage());
    System.out.println(runtimeException.getMessage());

  }
}
