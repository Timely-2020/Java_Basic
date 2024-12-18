package com.example.demo_Basic.advance.fileOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Student implements Serializable {

  @Override
  public String toString() {
    return "Student{" + "name='" + name + '\'' + ", age=" + age + ", x=" + x + '}';
  }

  String name;
  Integer age;
  //  Ignore For Serialization
  transient int x;
}

public class SerializationDemo {

  public static void main(String[] args) throws IOException {
    Student student = new Student("Sham", 12, 1);
    String filename = "C:\\Users\\D951197\\SDWAN\\BE\\Demo\\txt.txt";
    //   Serialization
    FileOutputStream out = null;
    ObjectOutputStream obj = null;
    try {
      out = new FileOutputStream(filename);
      obj = new ObjectOutputStream(out);
      obj.writeObject(student);
      System.out.println("Object serialized successfully");
    } finally {
      assert out != null;
      out.close();
      assert obj != null;
      obj.close();
    }
    //De-Serialization
    FileInputStream in = null;
    ObjectInputStream objIn = null;
    try {
      in = new FileInputStream(filename);
      objIn = new ObjectInputStream(in);
      Student deserial = (Student) objIn.readObject();
      System.out.println("Object de-serialized successfully, Student :-" + deserial.toString());
    } catch (ClassNotFoundException e) {
      System.out.println("Class Not found Exception");
    } finally {
      out.close();
      obj.close();
    }
  }
}
