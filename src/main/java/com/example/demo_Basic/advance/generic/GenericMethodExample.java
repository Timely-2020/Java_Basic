package com.example.demo_Basic.advance.generic;

public class GenericMethodExample {

  // A generic method that accepts any type of parameter
  public <T> void printArray(T[] array) {
    for (T element : array) {
      System.out.println(element);
    }
  }

  // A generic method with two type parameters
  public <T, U> void printKeyValue(T key, U value) {
    System.out.println("Key: " + key + ", Value: " + value);
  }

  // A generic method with an upper bound (T must be a subclass of Number)
  public <T extends Number> void printDoubleValue(T number) {
    System.out.println(number.doubleValue());
  }

  public static void main(String[] args) {
    GenericMethodExample example = new GenericMethodExample();

    Integer[] intArray = {1, 2, 3, 4, 5};
    String[] strArray = {"A", "B", "C"};

    // Calling the generic method
    example.<Integer>printArray(intArray);  // Explicitly specifying the type
    example.printArray(strArray);           // The compiler infers the type

    example.<String, Integer>printKeyValue("Age", 30);  // Explicit type specification
    example.printKeyValue("Height", 180.5);             // Type inference

    example.printDoubleValue(5);        // Integer (subclass of Number)
    example.printDoubleValue(3.14);     // Double (subclass of Number)
    // example.printDoubleValue("Text"); // Compilation error: String is not a subclass of Number
  }
}
