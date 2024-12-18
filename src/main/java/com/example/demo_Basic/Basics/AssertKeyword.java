package com.example.demo_Basic.Basics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssertKeyword {

  public static void main(String[] args) {
    int val = -5;
    try {
      //Simple assert
      //      assert val > 0;
      //Assert with message
      assert val > 0 : "Value should be non-negative integer";
    } catch (AssertionError e) {
      log.error("error is {}", e.getMessage());
    }
  }
}
