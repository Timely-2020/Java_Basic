package com.example.demo_Basic.Basics.thread;

class Counter {

  int count;

  //  Synchronized keyword -> to avoid the race Condition, by allowing only one thread should access one method.
  public synchronized void increment() {
    this.count++;
  }
}

public class RaceCondition {

  public static void main(String[] args) throws InterruptedException {
    Counter c1 = new Counter();
    int num[] = {1, 2, 3};
    Runnable r3 = () -> {
      for (int i = 0; i < 1000; i++) {
        //        System.out.println("Thread 1 Executed");
        c1.increment();
      }
    };

    Runnable r4 = () -> {
      for (int i = 0; i < 1000; i++) {
        //        System.out.println("Thread 2 Executed");
        c1.increment();
      }
    };
    Thread t5 = new Thread(r3);
    Thread t6 = new Thread(r4);
    t5.start();
    t6.start();
    t5.join();
    t6.join();
    System.out.println("c1 = " + c1.count);
  }
}
