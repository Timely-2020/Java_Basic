package com.example.demo_Basic.advance.async;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombineCompletableFuture {

  public CompletableFuture<Employee> getEmployeeDetails() {
    List<Employee> employees = ChainingCompletableFutureDemo.getEmployees(new File("Employee.json"));

    CompletableFuture<Employee> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("getEmployeeDetails: Thread name" + Thread.currentThread().getName());
      return employees.stream().filter((e) -> e.getId().equals(1L)).findAny().orElse(null);
    });
    return future;
  }

  public CompletableFuture<Integer> getEmployeeRating(Employee e) {
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("getEmployeeRating: Thread name" + Thread.currentThread().getName());
      return e.getRating();
    });
    return future;
  }

  public CompletableFuture<Integer> getNewJoinerCount() {
    List<Employee> employees = ChainingCompletableFutureDemo.getEmployees(new File("Employee.json"));
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("getNewJoinerCount: Thread name" + Thread.currentThread().getName());
      return employees.stream().filter(Employee::getNewJoiner).toList().size();
    });
  }

  public CompletableFuture<Integer> getTrainingPendingCount() {
    List<Employee> employees = ChainingCompletableFutureDemo.getEmployees(new File("Employee.json"));
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("getTrainingPendingCount: Thread name" + Thread.currentThread().getName());
      return employees.stream().filter(Employee::getTrainingPending).toList().size();
    });
  }

  public CompletableFuture<Set<Long>> getEmployeesSalaryList() {
    List<Employee> employees = ChainingCompletableFutureDemo.getEmployees(new File("Employee.json"));
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("getEmployeesSalaryList: Thread name" + Thread.currentThread().getName());
      return employees.stream().map(Employee::getSalary).collect(Collectors.toSet());
    });
  }

  public void addDelay(Integer millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public CompletableFuture<Double> getStockPriceApi1() {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("getStockPriceApi1: Thread name" + Thread.currentThread().getName());
      addDelay(500);
      return 150.0;
    });
  }

  public CompletableFuture<Double> getStockPriceApi2() {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("getStockPriceApi2: Thread name" + Thread.currentThread().getName());
      addDelay(2000);
      return 155.00;
    });
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    CombineCompletableFuture cf = new CombineCompletableFuture();
    // -------------------------Combine two dependent Future ------------------------
    /*
    if we use thenApply it will return chain of CompletableFuture<CompletableFuture<Integer>> to avoid this use thenCompose
    CompletableFuture<CompletableFuture<Integer>> ratingByThenApply = cf.getEmployeeDetails().thenApply(cf::getEmployeeRating);
     */
//    CompletableFuture<Integer> rating = cf.getEmployeeDetails().thenCompose(cf::getEmployeeRating);
//    System.out.println("thenCompose result = " + rating.get());

    // -------------------------Combine two In-dependent Future ------------------------
//    CompletableFuture<String> thenCombineEx = cf.getNewJoinerCount().thenCombine(cf.getTrainingPendingCount(), (newJoinerCount, trainingPendingCount) -> {
//      return "NewJoinerCount - " + newJoinerCount + " " + "TrainingPendingCount - " + trainingPendingCount;
//    });
//    System.out.println("thenCombine result = " + thenCombineEx.get());

    // -------------------------Combine N In-dependent Future's ------------------------
//    CompletableFuture<Integer> newJoinerFuture = cf.getNewJoinerCount();
//    CompletableFuture<Integer> trainingPendingFuture = cf.getTrainingPendingCount();
//    CompletableFuture<Set<Long>> employeesSalaryFuture = cf.getEmployeesSalaryList();
//
//    //wait for all future to complete
//    CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(newJoinerFuture, trainingPendingFuture, employeesSalaryFuture);
//    //Process future result once all is completed.
//    combinedFuture.thenRun(() -> {
//      Integer newJoinerCount = newJoinerFuture.join();
//      System.out.println("newJoinerCount = " + newJoinerCount);
//      Integer trainingPendingCount = trainingPendingFuture.join();
//      System.out.println("trainingPendingCount = " + trainingPendingCount);
//      Set<Long> salaryList = employeesSalaryFuture.join();
//      System.out.println("salaryList = " + salaryList);
//    }).join();
    // -------------------------Combine N In-dependent Future's and anyOf()------------------------
    CompletableFuture<Double> stockPriceApi1 = cf.getStockPriceApi1();
    CompletableFuture<Double> stockPriceApi2 = cf.getStockPriceApi2();

    //wait to complete any one future
    CompletableFuture<Object> anyOffFuture = CompletableFuture.anyOf(stockPriceApi2, stockPriceApi1);
    //Process completed future result
    anyOffFuture.thenAccept((price) -> {
      System.out.println("StockPrice is = " + price);
    }).get();
  }
}
