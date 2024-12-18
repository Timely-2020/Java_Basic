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
import java.util.stream.Collectors;

/*
 Explained usage of thenApply/thenAppyAsync, thenAccept/thenAcceptAsync
 */
public class ChainingCompletableFutureDemo {

  public static List<Employee> getEmployees(File employeeFile) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(employeeFile, new TypeReference<List<Employee>>() {
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /*
  Here all tasks uses Thread from ForkJoinPool
  it uses thenApply
   */
  public static void trainingRemainder() throws ExecutionException, InterruptedException {
    System.out.println("trainingRemainder Started");
    CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("Get Employees - Thread name " + Thread.currentThread().getName());
      return getEmployees(new File("Employee.json"));
    }).thenApply((employees) -> {
      System.out.println("get New Joiner Employees - Thread name " + Thread.currentThread().getName());
      return employees.stream().filter(Employee::getNewJoiner).collect(Collectors.toList());
    }).thenApply((employees) -> {
      System.out.println("Get Training pending List - Thread name " + Thread.currentThread().getName());
      return employees.stream().filter(Employee::getTrainingPending).collect(Collectors.toList());
    }).thenAccept((employees) -> {
      System.out.println("send Notification - Thread name " + Thread.currentThread().getName());
      employees.forEach((e) -> System.out.println("Employee-Name is = " + e.getName()));
    });
    future.get();
  }

  /*
  supplyAsync uses Thread from Custom Executors
 thenApplyAsync uses Thread from ForkJoinPool
  */
  public static void trainingRemainderWithCustomExecutor() throws ExecutionException, InterruptedException {
    Executor executor = Executors.newFixedThreadPool(3);
    System.out.println("trainingRemainderWithCustomExecutor Started");
    CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("Get Employees - Thread name " + Thread.currentThread().getName());
      return getEmployees(new File("Employee.json"));
    }, executor).thenApplyAsync((employees) -> {
      System.out.println("get New Joiner Employees - Thread name " + Thread.currentThread().getName());
      return employees.stream().filter(Employee::getNewJoiner).collect(Collectors.toList());
    }).thenApplyAsync((employees) -> {
      System.out.println("Get Training pending List - Thread name " + Thread.currentThread().getName());
      return employees.stream().filter(Employee::getTrainingPending).collect(Collectors.toList());
    }).thenAcceptAsync((employees) -> {
      System.out.println("send Notification - Thread name " + Thread.currentThread().getName());
      employees.forEach((e) -> System.out.println("Employee-Name is = " + e.getName()));
    });
    future.get();
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ChainingCompletableFutureDemo.trainingRemainder();
    ChainingCompletableFutureDemo.trainingRemainderWithCustomExecutor();
  }
}
