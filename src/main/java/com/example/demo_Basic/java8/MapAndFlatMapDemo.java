package com.example.demo_Basic.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMapDemo {

  public static void main(String[] args) {
    List<Integer> even = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
    List<Integer> evenMultiple = even.stream().map((no) -> no * 2).collect(Collectors.toList());
    System.out.println("evenMultiple = " + evenMultiple);
    List<List<String>> cities = new ArrayList<>(
        Arrays.asList(Arrays.asList("mysore", "Bangalore"), Arrays.asList("kochi"),
            Arrays.asList("chennai", "madurai")));
    List<String> citiesNames =
        cities.stream().flatMap((citiesName) -> citiesName.stream()).collect(Collectors.toList());
    System.out.println("citiesNames = " + citiesNames);
  }
}
