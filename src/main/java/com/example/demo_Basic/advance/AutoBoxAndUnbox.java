package com.example.demo_Basic.advance;

public class AutoBoxAndUnbox {

  public static void main(String[] args) {
    Integer val = 10;
    //   ---------------Auto-Boxing---------------
    Integer wVal = Integer.valueOf(val);
    System.out.println("Auto-Boxed value is" + wVal);
    Character c = 'c';
    System.out.println("Auto-Boxed value of Character is" + c);
    //    ---------------Auto-Unboxing---------------
    int newVal = wVal;
    System.out.println("Auto-UnBoxed value is" + newVal);
  }
}
