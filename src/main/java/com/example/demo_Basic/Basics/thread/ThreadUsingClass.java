package com.example.demo_Basic.Basics.thread;

class At1 extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hi");
      try {
        Thread.sleep(0);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class Bt1 extends Thread {

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hello");
    }
  }
}

public class ThreadUsingClass {

  public static void main(String[] args) {
    //Thread Creation using class
    At1 obj = new At1();
    Bt1 obj1 = new Bt1();
    //Setting priority of thread for scheduler
    obj1.setPriority(Thread.MAX_PRIORITY); //1-Least, 5-Normal, 10-Max
    obj.start();
    obj1.start();
  }
}
