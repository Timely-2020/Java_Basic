package com.example.demo_Basic.Basics.dataType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
  public static void main(String[] args) {
    //------------------current date in default format------------------
    Date date = new Date();
    System.out.println("date = " + date); // o/p -> Wed Dec 11 13:53:33 IST 2024
    //------------------Date using milliseconds---------------------------
    // Get the current time in milliseconds since January 1, 1970
    Long dateInMillis = System.currentTimeMillis();
    Date date2 = new Date(dateInMillis);
    System.out.println("Date from millis = " + date2); // o/p -> Wed Dec 11 13:53:33 IST 2024
    //------------------Custom Formated Date-------------------------------
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = formatter.format(date);
    System.out.println("formattedDate = " + formattedDate); //o/p -> 2024-12-11 13:53:33
  }
}
