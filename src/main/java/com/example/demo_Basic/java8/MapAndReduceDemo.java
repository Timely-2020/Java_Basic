package com.example.demo_Basic.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapAndReduceDemo {

  public static void main(String[] args) {
    List<Integer> num = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 8, 9));
    Integer sum = num.stream().reduce(0, (result, element) -> result + element);
    //    num.stream().reduce(Integer::sum);
    System.out.println("sum = " + sum);

    Integer max = num.stream().reduce(0, (a, b) -> a > b ? a : b);
    System.out.println("max = " + max);
    //Return longest string
    List<String> names = new ArrayList<>(Arrays.asList("Shyam", "Bhama", "Lama", "thama", "sumitra", "kaike"));
    names.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
  }
}
