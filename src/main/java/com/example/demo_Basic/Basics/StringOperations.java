package com.example.demo_Basic.Basics;

import java.io.IOException;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringOperations {

  public static void main(String[] args) throws IOException {

    log.info("Assign values During Creation");
    String[] fruits = {"Apple", "mango", "Orange"};
    String[] trees = new String[]{"Banana", "Coconut", "Mango", "Teak", "Sal"};

    String text = "String split contains duplicates String in split";

    System.out.println("Substring" + text.substring(0, 5));
    System.out.println("Replace" + text.replace("String", "new String"));

    String[] sub = text.split(" ");
    Arrays.stream(sub).forEach(s -> System.out.print(s + " "));
  }
}
