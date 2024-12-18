package com.example.demo_Basic.Basics;

public class VarArgsDemo {

  public static void main(String[] args) {
    printArgs(new String[]{"one"});
    printArgsAnotherWay("one", "two");
  }

  public static void printArgs(String[] names) {
    for (String s : names) {
      System.out.println("s = " + s);
    }
  }

  public static void printArgsAnotherWay(String... names) {
    for (String s : names) {
      System.out.println("s = " + s);
    }
  }
}
