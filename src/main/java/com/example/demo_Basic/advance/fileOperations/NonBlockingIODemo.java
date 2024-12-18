package com.example.demo_Basic.advance.fileOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NonBlockingIODemo {

  public static void main(String[] args) throws IOException {
    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\D951197\\SDWAN\\BE\\Demo\\Source.txt");
    FileChannel channel = fileInputStream.getChannel();
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    int read = channel.read(buffer);
    System.out.println("File read Successfully with length = " + read);

    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\D951197\\SDWAN\\BE\\Demo\\Dst.txt");
    FileChannel writeChannel = fileOutputStream.getChannel();
    writeChannel.write(buffer);
    System.out.println("File Written Successfully ");
  }
}
