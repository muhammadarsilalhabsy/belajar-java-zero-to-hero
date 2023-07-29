package com.m19y.learn.unittest;

import org.junit.jupiter.api.*;

public class BeforeEachBeforeAllAfterEachAndAfterAllTest {

  // BeforeAll or AfterAll will execute once (the method should be static, or they will error)
  @BeforeAll
  public static void beforeAll(){
    System.out.println("Before All==========>");
  }

  @AfterAll
  public static void afterAll(){
    System.out.println("After All==========>");
  }

  // BeforeEach or AfterEach will execute for every single test when it's running
  @BeforeEach
  public void setUp(){
    System.out.println("Before each");
  }

  @AfterEach
  public void tearDown(){
    System.out.println("after each");
  }

  @Test
  void first() {
    // some action
    System.out.println("first");
  }
  @Test
  void second() {
    // some action
    System.out.println("second");
  }
  @Test
  void third() {
    // some action
    System.out.println("third");
  }
}
