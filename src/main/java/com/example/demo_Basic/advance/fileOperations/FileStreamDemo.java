package com.example.demo_Basic.advance.fileOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo<T> {

  public static void main(String[] args) throws IOException {

    FileInputStream reader = null;
    FileOutputStream writer = null;
    try {
      reader = new FileInputStream("C:\\Users\\D951197\\SDWAN\\BE\\Demo\\Source.txt");
      writer = new FileOutputStream("C:\\Users\\D951197\\SDWAN\\BE\\Demo\\Dst.txt");
      int content;
      while ((content = reader.read()) != -1) {
        writer.write((byte) content);
      }
    } catch (Exception e) {

    } finally {
      if (reader != null) {
        reader.close();
      }
      if (writer != null) {
        writer.close();
      }
    }
  }
}
