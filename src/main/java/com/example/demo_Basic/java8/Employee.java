package com.example.demo_Basic.java8;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Employee {

  private String name;
  private Integer age;

  Employee(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
}
