package com.example.demo_Basic.Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputReaderDemo {

  public static void main(String[] args) throws IOException {

    //One character Read
    try {
      System.out.println("Enter a Number");
      int num = System.in.read();
      System.out.println("num = " + num);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //Complete input Read - Scanner(from 1.5)
    System.out.println("Enter a Number for Scanner");
    Scanner scanner = new Scanner(System.in);
    System.out.println("scanner = " + scanner.next()); //For Input int-nextInt(), String-next()
    scanner.close();

    //BufferReader - Earlier
    System.out.println("Enter a Number for BufferedReader");
    InputStream stream = System.in;
    InputStreamReader inputStreamReader = new InputStreamReader(stream);
    BufferedReader reader = new BufferedReader(inputStreamReader);
    System.out.println("Bufferreader = " + reader.readLine());
    reader.close();
  }
}
