package com.example.demo_Basic.Basics.Interface;

//Add annotation @FunctionalInterface .
@FunctionalInterface
interface Obj {

  String show(String msg);
}

//	Separate Class for implementation
class A implements Obj {

  @Override
  public String show(String msg) {
    System.out.println("obj showing....");
    return msg;
  }
}

public class FunctionalInterfaceDemo {

  public static void main(String[] args) {

    //		Single arg - no need (), single line body no need {}, single line no return.
    Obj lambdaOpt = i -> i;
    lambdaOpt.show("Optimized lambda");

    //	with Lambda expression ,no need to mention the type for arguments
    Obj lambda = (i) -> {
      System.out.println(i + " impl");
      return i;
    };
    lambda.show("Non-Optimized lambda");

    //	Anonymous class while object creation
    Obj anonymous = new Obj() {
      @Override
      public String show(String msg) {
        System.out.println(msg + " implementation");
        return msg;
      }
    };
    anonymous.show("Anonymous Class");
  }
}
