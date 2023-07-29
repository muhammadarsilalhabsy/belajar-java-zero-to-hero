package com.m19y.learn.reflection.data;

public enum Gender {

  Male("Jantan"),
  Female("Betina");

  private final String desc;

  Gender(String desc){
    this.desc = desc;
  }

  public String getNameDesc(){
    return desc;
  }


}
