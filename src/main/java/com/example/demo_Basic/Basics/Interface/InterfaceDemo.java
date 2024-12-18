package com.example.demo_Basic.Basics.Interface;

/*
 * Declare using interface keyword, only final static variables are allowed, by default class and methods are public abstract.
 * Default and static methods are allowed.
 * Extend by another interface
 * Implementation using class
 * Instantiation - Holds reference of the Implementation object. Can't access method of implemented classes.
 */

import java.io.Serializable;

interface Vehicle {

  final static String wheels = "four";

  static void describe() {
    System.out.println("Vehicle are used for transportation.");
  }

  void drive();
}

interface Car extends Vehicle {

  default void stop() {
    System.out.println("stop the Car");
  }

  default void start() {
    System.out.println("start the Car");
  }
}

class CarImpl implements Car {

  String model;

  CarImpl(String model) {
    this.model = model;
  }

  @Override
  public void drive() {
    System.out.println("driving...");
  }
}

public class InterfaceDemo {

  public static void main(String[] args) {
    Car car = new CarImpl("xv4");
    Vehicle.describe();
    car.start();
    car.drive();
    car.stop();
  }
}
