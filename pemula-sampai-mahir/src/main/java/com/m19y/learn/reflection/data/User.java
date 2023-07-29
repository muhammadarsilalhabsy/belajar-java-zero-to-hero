package com.m19y.learn.reflection.data;

import com.m19y.learn.reflection.annotation.NotBlank;

import java.util.List;

public class User {

  @NotBlank
  private String name;

  @NotBlank
  private String password;

  @NotBlank(allowEmptyString = true)
  private String email;

  private int age;

  private List<String> hobbies;

  public List<String> getHobbies() {

    return hobbies;
  }

  public void setHobbies(List<String> hobbies) {
    this.hobbies = hobbies;
  }

  public User(){}
  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public User(String name, String password, String email) {
    this(name, password);
    this.email = email;
  }

  public User(String name, String password, String email, int age) {
    this(name, password, email);
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            '}';
  }
}
