package com.example.demo_Basic.Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TryWithResources extends Error {

  public static void main(String[] args) throws IOException {
    //try with Resource
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("Bufferreader = " + reader.readLine());
    }

    //    try with Finally block
    BufferedReader reader = null;
    try {
      InputStream stream = System.in;
      InputStreamReader inputStreamReader = new InputStreamReader(stream);
      reader = new BufferedReader(inputStreamReader);
      System.out.println("Bufferreader = " + reader.readLine());
    } finally {
      reader.close();
    }
  }
}
