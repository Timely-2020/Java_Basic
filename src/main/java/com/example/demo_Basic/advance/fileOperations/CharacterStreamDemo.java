package com.example.demo_Basic.advance.fileOperations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo<T> {

  public static void main(String[] args) throws IOException {

    FileReader reader = null;
    FileWriter writer = null;
    try {
      reader = new FileReader("C:\\Users\\D951197\\SDWAN\\BE\\Demo\\Source.txt");
      writer = new FileWriter("C:\\Users\\D951197\\SDWAN\\BE\\Demo\\Dst.txt");
      int content;
      while ((content = reader.read()) != -1) {
        writer.append((char) content);
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
