package com.example.demo_Basic.Basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

enum Status {
  STARTED, INPROGRESS, SUCCESS, FAILED;
}

enum Number {
  ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), ANY;
  private int num;

  Number() {
    this.num = 0;
    System.out.printf("Default called %d %n", num);
  }

  Number(int num) {
    this.num = num;
    System.out.printf("All called %d %n", num); //%n(new line)
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getNum() {
    return this.num;
  }
}

public class EnumerationDemo<T> {

  public static void main(String[] args) {
    /*
    * 	Define List of Fixed Constants
	      Access its index
        Iterate*/
    Status job = Status.FAILED;
    System.out.printf("Job Status is %s, its index is %d %n", job, job.ordinal());
    Status[] ss = Status.values();
    for (Status s : ss) {
      System.out.println(s);
    }
  /*
  When Enum is instantiated Corresponding(based on args) Constructor called for all constants
  Assign value, Getters and setter to get and set the values
	Default Constructor for default value assignment
  */
    Number.ANY.setNum(10);
    Number.ONE.setNum(11);
    for (Number n : Number.values()) {
      System.out.println("n = " + n + "  " + n.getNum());
    }
  }
}

