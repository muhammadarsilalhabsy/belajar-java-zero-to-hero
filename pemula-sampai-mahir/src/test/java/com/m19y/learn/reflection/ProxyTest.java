package com.m19y.learn.reflection;

import com.m19y.learn.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

  @Test
  void testProxy() {

    InvocationHandler handler = new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("getName")){
          return "Lamborghini";
        }
        if(method.getName().equals("run")){
          System.out.println("Lari lari lari");
        }
        return null;
      }
    };

    // proxy

    Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Car.class}, handler);
    System.out.println(car.getClass());
    System.out.println(car.getName());
    car.run();
  }
}
