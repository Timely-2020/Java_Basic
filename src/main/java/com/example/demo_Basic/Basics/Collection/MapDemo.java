package com.example.demo_Basic.Basics.Collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapDemo {

  public static void main(String[] args) {
    // -------------------------   Map(not in original sequence)---------------------
    Map<Integer, String> numbers = new HashMap<>();
    numbers.put(3, "three");
    numbers.put(1, "one");
    numbers.put(2, "two");
    numbers.put(2, "TWO");
    for (Map.Entry<Integer, String> entry : numbers.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
    for (Integer n : numbers.keySet()) {
      System.out.println(n + numbers.get(n));
    }

    //   ---------------------------------- hashTable(synchronized)---------------
    Map<Integer, String> map1 = new Hashtable<>();
    map1.put(3, "three");
    map1.put(1, "one");
    map1.put(2, "two");
    for (Integer n : map1.keySet()) {
      System.out.println(n + map1.get(n));
    }
  }
}
