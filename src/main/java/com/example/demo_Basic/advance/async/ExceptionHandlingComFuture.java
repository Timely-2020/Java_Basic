package com.example.demo_Basic.advance.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandlingComFuture {

  public void createError() {
    throw new RuntimeException("500 internal server Error");
  }

  public CompletableFuture<String> backupEmployeeDB() {
    return CompletableFuture.supplyAsync(() -> {
          createError();
          return "Employees Details are Backed up Successfully";
        })
        .exceptionally((err) -> {
          return "Employees Details Backed up Failed";
        });
  }

  public CompletableFuture<String> backupEmployeeDB1() {
    return CompletableFuture.supplyAsync(() -> {
      createError();
      return "Employees Details are Backed up Successfully";
    });
  }

  public CompletableFuture<String> backupEmployeeS3Doc() {
    return CompletableFuture.supplyAsync(() -> {
      createError();
      return "Employees Document are uploaded to S3 Successfully";
    }).exceptionally((err) -> {
      return "Employees Document S3 upload Failed";
    });
  }

  public CompletableFuture<String> backupEmployeeS3Doc1() {
    return CompletableFuture.supplyAsync(() -> {
      createError();
      return "Employees Document are uploaded to S3 Successfully";
    });
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExceptionHandlingComFuture cf = new ExceptionHandlingComFuture();
    System.out.println("--Individual Exception Handling--");
    CompletableFuture<String> future = cf.backupEmployeeDB().thenCombine(cf.backupEmployeeS3Doc(), (r1, r2) -> {
      return r1 + "\n" + r2;
    });
    System.out.println(future.get());

    System.out.println("--Global Exception Handling--");
    CompletableFuture<Object> future1 = cf.backupEmployeeDB1().thenCombine(cf.backupEmployeeS3Doc1(), (r1, r2) -> {
      return r1 + "\n" + r2;
    }).handle((res, err) -> {
      if (err != null) {
        return err.getMessage();
      }
      return res;
    });
    System.out.println(future1.get());
  }
}
