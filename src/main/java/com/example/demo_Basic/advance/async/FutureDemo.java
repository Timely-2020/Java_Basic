package com.example.demo_Basic.advance.async;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class FutureDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService service = Executors.newFixedThreadPool(3);
    //--------------- Future with submit() + Callable func() ---------------
    Future<String> future1 = service.submit(() -> {
      log.info("Tread Name is:{}", Thread.currentThread().getName());
      try {
        //any operations can be done
        Thread.sleep(10);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return "Success";
    });

    String res1 = future1.get();
    System.out.println("Future.submit(callable) response is  = " + res1);

    // ---------------Future submit + Runnable func() -----------------
    Future<?> future2 = service.submit(() -> {
      log.info("Tread Name is:{}", Thread.currentThread().getName());
      try {
        //any operations can be done
        Thread.sleep(10);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    System.out.println("Future.submit(Runnable) response is  = " + future2.get());
  }
}

