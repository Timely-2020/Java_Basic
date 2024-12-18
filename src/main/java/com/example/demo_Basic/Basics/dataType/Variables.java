package com.example.demo_Basic.Basics.dataType;

public class Variables {

  String uninitializedName;

  void checkDefaultValue() {
    String name = "";
    System.out.println(name == null);
    System.out.println(this.uninitializedName == null);
  }

  void integerRange() {
    System.out.println("Max int value is" + Integer.MAX_VALUE); // Output: 2147483647
    System.out.println("Min int value is" + Integer.MIN_VALUE); // Output: -2147483648
  }

  public static void main(String[] args) {
    Variables variables = new Variables();
    variables.checkDefaultValue();
  }
}
