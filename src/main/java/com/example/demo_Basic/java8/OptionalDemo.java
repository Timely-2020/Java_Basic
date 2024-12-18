package com.example.demo_Basic.java8;

import java.util.NoSuchElementException;
import java.util.Optional;

// To Avoid the Null pointer exceptions
public class OptionalDemo {

  public static void main(String[] args) {

    Employee e = new Employee("Sham", 12);

    //    empty - to get the empty optional
    Optional<Object> obj = Optional.empty();
    //    of - Object is non-nullable value
    Optional<Object> obj1 = Optional.of(e.getName());
    //    of - Object can nullable
    Optional<String> obj2 = Optional.ofNullable(e.getName());

    if (obj2.isPresent()) {
      System.out.println("obj2.get() = " + obj2.get());
    }

    System.out.println("obj2.get() = " + obj2.orElse("EMPTY")); // if obj is empty return this given value
    System.out.println("obj2.get() = " + obj2.orElseGet(() -> "EMPTY"));  // if obj is empty return supplier output.

    System.out.println("obj2.get() = " + obj2.orElseThrow(
        () -> new NoSuchElementException("Element is not present")));  // if obj is empty throw exception.

    /*
    If value Preset,
     .mpa()- it passes value as arg to mapper function and return function result.
      .orElseGet() - if not present then return same type response.
     */
    System.out.println("obj2.get() = " + obj2.map(String::toUpperCase)
        .orElseGet(() -> "Default value"));  // if obj is empty return supplier output.
  }
}
