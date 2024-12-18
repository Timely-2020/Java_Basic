package com.example.demo_Basic.Basics.thread;

import lombok.SneakyThrows;

class Runnable1 implements Runnable {

  @SneakyThrows
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hi");
      Thread.sleep(2);
    }
  }
}

class Runnable2 implements Runnable {

  @SneakyThrows
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hello");
      Thread.sleep(4);
    }
  }
}

public class ThreadUsingRunnable {

  public static void main(String[] args) {
    //    Thread Creation using Lambda
    Runnable r3 = () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Hi");
      }
    };

    Runnable r4 = () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Hello");
      }
    };
    Thread t5 = new Thread(r3);
    Thread t6 = new Thread(r4);
    //    t5.start();
    //    t6.start();

    //    Thread Creation using anonymous Class
    Runnable r1 = new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("Hi");
          Thread.sleep(2);
        }
      }
    };

    Runnable r2 = new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("Hello");
          Thread.sleep(2);
        }
      }
    };
    Thread t3 = new Thread(r1);
    Thread t4 = new Thread(r2);
    //    t3.start();
    //    t4.start();

    //Thread Creation using Runnable With Class
    Runnable1 obj = new Runnable1();
    Runnable2 obj1 = new Runnable2();
    Thread t1 = new Thread(obj);
    Thread t2 = new Thread(obj1);
    t1.start();
    t2.start();
  }
}
