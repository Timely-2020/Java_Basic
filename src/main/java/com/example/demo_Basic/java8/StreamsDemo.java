package com.example.demo_Basic.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class StreamsDemo {

  public static void main(String[] args) {
    //    //For List
    //    List<Integer> prime = new ArrayList<>(Arrays.asList(2, 13, 5, 17, 11, 3));
    //    prime.stream().forEach((i) -> i = i * 2);
    //    List<Integer> res = prime.stream().filter((i) -> i % 2 == 0).collect(Collectors.toList());
    //
    //    //    Sorting primitive, obj(lambda, comparator, comparator+methodReference)
    //    prime.stream().sorted().forEach(System.out::println);
    //    prime.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    //    prime.stream().sorted((i, j) -> i - j).forEach(System.out::println);
    //
    //    List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("Gopal", 46), new Employee("Mohan", 67)));
    //    System.out.println("ASCENDING");
    //    employees.stream().sorted((e1, e12) -> e1.getAge() - e12.getAge()).forEach(System.out::println);
    //    System.out.println("DESCENDING");
    //    employees.stream().sorted((e1, e2) -> e2.getAge() - e1.getAge()).forEach(System.out::println);
    //    System.out.println("ASCENDING + Comparator-lambda");
    //    employees.stream().sorted(Comparator.comparing((e) -> e.getName())).forEach(System.out::println);
    //    System.out.println("ASCENDING Comparator-Method-Reference");
    //    employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

    //For Map
    Map<Integer, Integer> square = new HashMap<>();
    square.put(2, 4);
    square.put(8, 64);
    square.put(4, 16);
    square.put(7, 49);
    //    square.entrySet().stream().filter((i) -> i.getKey() * i.getValue() % 2 == 0).collect(Collectors.toList());
    //    square.entrySet().stream().forEach((i) -> System.out.println("i.getKey() = " + i.getKey() + i.getValue()));

    //    System.out.println("Sort using Collection");
    //    List<Entry<Integer, Integer>> squareList = new ArrayList<>(square.entrySet());
    //    Collections.sort(squareList, (o1, o2) -> o1.getKey() - o2.getKey());
    //    Collections.sort(squareList, Comparator.comparingInt(Entry::getKey));
    //    System.out.println("Sort by keys Ascending");
    //    square.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    //    System.out.println("Sort by values Ascending");
    //    square.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    //    System.out.println("Sort by Values descending");
    //    square.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
    //        .forEach(System.out::println);
    //
    //    System.out.println("Custom Objects sort");
    //    Map<Employee, Integer> emplyeesData = new TreeMap<>(Comparator.comparingInt(Employee::getAge));
    //    emplyeesData.put(new Employee("Raghu", 31), 1);
    //    emplyeesData.put(new Employee("Guru", 78), 5);
    //    emplyeesData.put(new Employee("Mahesh", 21), 6);
    //    System.out.println("Ascending");
    //    emplyeesData.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
    //        .forEach(System.out::println);
    //    System.out.println("descending");
    //    emplyeesData.entrySet().stream()
    //        .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName).reversed()))
    //        .forEach(System.out::println);

    //    Parallel Streams
    List<Employee> rawEmployee = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      rawEmployee.add(new Employee("Employee" + i, i));
    }
    long start = 0;
    long end = 0;
    OptionalDouble average = OptionalDouble.of(0.0);
    start = System.currentTimeMillis();
    average = rawEmployee.stream().map(Employee::getAge).mapToDouble(i -> i).average();
    end = System.currentTimeMillis();
    System.out.println("time taken is = " + (end - start) + " " + average);

    start = System.currentTimeMillis();
    average = rawEmployee.parallelStream().map(Employee::getAge).mapToDouble(i -> i).average();
    end = System.currentTimeMillis();
    System.out.println("time taken is = " + (end - start) + " " + average);
  }
}
