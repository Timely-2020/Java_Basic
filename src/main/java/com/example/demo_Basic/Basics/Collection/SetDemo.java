package com.example.demo_Basic.Basics.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

  public static void main(String[] args) {
    //------------------------------------ Set-Interface---------------------
    //    -------HashSet( not sorted)---
    Set<Integer> arr = new HashSet<Integer>(List.of(6, 7, 8, 3, 2, 6, 19, 18, 3, 5, 1));
    arr.add(7);
    System.out.println("arr = " + arr);
    for (Integer n : arr) {
      //      System.out.println("n = " + n);
    }

    //    TreeSet-> sorted
    Set<Integer> arr1 = new TreeSet<>(List.of(6, 7, 8, 3, 2, 6));
    arr1.add(7);
    System.out.println("arr1 = " + arr1);
  }
}
