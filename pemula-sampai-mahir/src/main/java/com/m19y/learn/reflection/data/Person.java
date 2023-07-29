package com.m19y.learn.reflection.data;

import java.io.Serializable;

public class Person implements Nameable, Serializable {

  private String firstname;
  private String lastname;

  public int age;

  public Person(){}

  public Person(String firstname){
    this.firstname = firstname;
  }
  public Person(String firstname, String lastname, int age){
    this(firstname);
    this.lastname = lastname;
    this.age = age;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", age=" + age +
            '}';
  }
}
