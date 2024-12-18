package com.example.demo_Basic.advance.generic;

import java.util.ArrayList;
import java.util.List;

class House extends Building {

  public int numberOfRooms = 10;

  @Override
  public String toString() {
    return ("house");
  }
}

public class WildCardGenerics {

  public static void main(String[] args) {

    // List of buildings
    List<Building> buildings = new ArrayList<>();
    buildings.add(new Building());
    buildings.add(new Building());
    printBuildings(buildings);

    // List of offices
    List<Office> offices = new ArrayList<>();
    offices.add(new Office("Mumbai"));
    offices.add(new Office("Kanpur"));
    printBuildings(offices);

    // List of houses
    List<House> houses = new ArrayList<>();
    houses.add(new House());
    houses.add(new House());
    printBuildings(houses);

    addHouseToList(houses);
    addHouseToList(buildings);
    //addHouseToList(offices); throws error
  }

  static void printBuildings(List<? extends Building> buildings) {
    for (int i = 0; i < buildings.size(); i++) {
      System.out.println(buildings.get(i).toString() + " " + (i + 1));
    }
    System.out.println();
  }

  static void addHouseToList(List<? super House> buildings) {
    buildings.add(new House());
    System.out.println();
  }
}
