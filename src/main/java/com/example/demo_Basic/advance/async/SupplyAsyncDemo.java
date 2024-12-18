package com.example.demo_Basic.advance.async;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class SupplyAsyncDemo {

  //It returns the result
  public static List<Employee> supplyAsync(File employeeFile) throws ExecutionException, InterruptedException {
    System.out.println("supplyAsync started");
    ObjectMapper mapper = new ObjectMapper();

    CompletableFuture<List<Employee>> future = CompletableFuture.supplyAsync(new Supplier<>() {
      @Override
      public List<Employee> get() {
        try {
          System.out.println("Thread name " + Thread.currentThread().getName());
          List<Employee> employees = mapper.readValue(employeeFile, new TypeReference<List<Employee>>() {
          });
          Thread.sleep(1000);
          return employees;
        } catch (IOException | InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    return future.get();
  }

  public static List<Employee> supplyAsyncWithCustomExecutor(
      File employeeFile) throws ExecutionException, InterruptedException {
    System.out.println("supplyAsyncWithCustomExecutor started");
    ObjectMapper mapper = new ObjectMapper();

    Executor executor = Executors.newFixedThreadPool(3);
    CompletableFuture<List<Employee>> future = CompletableFuture.supplyAsync(() -> {
      try {
        System.out.println("Thread name " + Thread.currentThread().getName());
        List<Employee> employees = mapper.readValue(employeeFile, new TypeReference<List<Employee>>() {
        });
        return employees;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }, executor);
    return future.get();
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    List<Employee> employees1 = SupplyAsyncDemo.supplyAsync(new File("employee.json"));
    System.out.println("SupplyAsyncDemo.list.size() = " + employees1.size());
    List<Employee> employees2 = SupplyAsyncDemo.supplyAsyncWithCustomExecutor(new File("employee.json"));
    System.out.println("supplyAsyncWithCustomExecutor.list.size() = " + employees2.size());
  }
}
