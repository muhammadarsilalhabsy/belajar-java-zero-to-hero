package com.m19y.learn.reflection.validation;

import com.m19y.learn.reflection.annotation.NotBlank;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;

public class Validator {

  public static void validateNotBlank(Object object) throws IllegalAccessException {

    // ambil classnya
    Class<?> objectClass = object.getClass();

    // ambil field-nya
    Field[] fields = objectClass.getDeclaredFields();


    // iterate fields
    for (Field field : fields){

      // check if field is private
      if(field.getModifiers() == Modifier.PRIVATE){
        field.setAccessible(true);
      }

      // get annotation not black
      NotBlank notBlank = field.getAnnotation(NotBlank.class);

      // check if annotation not blank is exists
      if(Objects.nonNull(notBlank)){

        // get field value (case not blank "String")
        String value = (String) field.get(object);

        if(notBlank.allowEmptyString()){
          // ignore
        }else{
          value = value.trim();
        }

        // check value if empty string
        if("".equals(value)){
          throw new RuntimeException(field.getName() + " must not blank!");
        }
      }
    }

  }
}
