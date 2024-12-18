package com.example.demo_Basic.advance.async;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class RunAsyncDemo {
  //it doesn't return.
  public static Void runAsync(File employeeFile) throws ExecutionException, InterruptedException {
    System.out.println("runAsync started");
    ObjectMapper mapper = new ObjectMapper();

    CompletableFuture<Void> future = CompletableFuture
        .runAsync(new Runnable() {
          @Override
          public void run() {
            try {
              System.out.println("Thread name " + Thread.currentThread().getName());
              List<Employee> employees = mapper.readValue(employeeFile, new TypeReference<List<Employee>>() {
              });
              employees.forEach(e -> {
                System.out.println(e.getName());
              });
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }
        });
    CompletableFuture
        .supplyAsync(() -> "Result")
        .orTimeout(1, TimeUnit.MINUTES);
    return future.get();

  }

  public static Void runAsyncWithCustomExecutor(File employeeFile) throws ExecutionException, InterruptedException {
    System.out.println("runAsyncWithCustomExecutor started");
    ObjectMapper mapper = new ObjectMapper();

    Executor executor = Executors.newFixedThreadPool(3);
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
      try {
        System.out.println("Thread name " + Thread.currentThread().getName());
        List<Employee> employees = mapper.readValue(employeeFile, new TypeReference<List<Employee>>() {
        });
        employees.forEach(e -> {
          System.out.println(e.getName());
        });
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }, executor);
    return future.get();
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    RunAsyncDemo.runAsync(new File("employee.json"));
    RunAsyncDemo.runAsyncWithCustomExecutor(new File("employee.json"));
  }
}
