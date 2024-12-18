package com.example.demo_Basic.Basics.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

class Student implements Comparable<Student> {

  String name;
  Integer age;

  public Student(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
  }

  @Override
  public int compareTo(@NotNull Student o) {
    return this.age == o.age ? 0 : this.age > o.age ? 1 : -1;
  }
}

@Slf4j
public class CollectionDemo {

  public static void main(String[] args) {
    //--------------------------- Collection( can't retrieve using index)-----------------------------
    Collection<Integer> number = new ArrayList<Integer>(List.of(8, 9, 2, 3, 4, 5));
    //----------Iterate Collection Using Iterator--------
    Iterator<Integer> itr = number.iterator();
    //    while (itr.hasNext()) {
    //      //      System.out.println(itr.next());
    //    }
    //---------Using Enhanced For loop---------
    //    for(Integer num: number){
    //      System.out.println(ele);
    //    }

    // --------------------------List (contains duplicates)----------------------------------
    // --------Declaring An List------
    List<Integer> arr1 = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 5));
    // log.info("{}", arr1.indexOf(5)); //indexOf
    //log.info("{}", arr1.get(1)); //access via index

    //--------------Sorting the List------
    List<Integer> arr2 = new ArrayList<Integer>(List.of(8, 9, 2, 3, 4, 5));
    System.out.println("Unsorted List" + arr2);
    // Ascending Order
    Collections.sort(arr2);
    System.out.println("Ascending List" + arr2);
    //Reverse/Descending order
    arr2.sort(Collections.reverseOrder());
    System.out.println("Descending List" + arr2);

    //------Sort Using Custom comparator------
    //Class level -> Implement Comparable
    List<Student> students = new ArrayList<>();
    students.add(new Student("Vinay", 12));
    students.add(new Student("Mahesh", 23));
    students.add(new Student("Lokesh", 93));
    students.add(new Student("Lamb", 2));
    System.out.println("Unsorted Student List = " + students);
    Collections.sort(students);
    System.out.println("sorted Student List = " + students);

    //		Create Comparator Obj with anonymous / lambda functions.
    List<String> names = new ArrayList<String>(List.of("John", "Ram", "Mohan", "Sachin ten", "ricky point"));
    System.out.println("Unsorted names" + names);
    Comparator<String> com = (o1, o2) -> Integer.compare(o1.length(), o2.length());

    //    Comparator<String> com = new Comparator<String>() {
    //      @Override
    //      public int compare(String o1, String o2) {
    //        return (o1.length() > o2.length()) ? 1 : -1;
    //      }
    //    };
    names.sort(com);
    System.out.println("Sorted Names" + names);
  }
}
