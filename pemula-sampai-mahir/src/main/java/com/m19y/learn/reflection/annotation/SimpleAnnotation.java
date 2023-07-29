package com.m19y.learn.reflection.annotation;

import java.lang.annotation.*;

@Documented // biar tersimpan di java dock
@Retention(RetentionPolicy.RUNTIME) // biar bisa di detace pada saat runtime
@Target(ElementType.PACKAGE)
public @interface SimpleAnnotation {
}
