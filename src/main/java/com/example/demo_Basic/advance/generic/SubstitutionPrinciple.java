package com.example.demo_Basic.advance.generic;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

class Building {

  @Override
  public String toString() {
    return "Building";
  }
}

@Getter
class Office extends Building {

  String location;

  Office(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "in Office class";
  }

  public String task() {
    return "in Office class";
  }
}

public class SubstitutionPrinciple {

  public static void main(String[] args) {

    Building building = new Building();
    Office office = new Office("bangalore");
    build(building);
    build(office);

    List<Building> buildings = new ArrayList();
    buildings.add(new Building());
    buildings.add(new Office("hyd"));
    printBuildings(buildings);

    //                List<Office> offices = new ArrayList();
    //                offices.add(new Office("bangalore"));
    //                offices.add(new Office("mumbai"));
    //                printBuildings(offices);

  }

  //  We can use Parent class to hold the reference for the child object; not in other way.
  static void build(Building building) {
    System.out.println("Constructing a new " + building.toString());
  }

  static void printBuildings(List<Building> buildings) {
    for (int i = 0; i < buildings.size(); i++) {
      System.out.println(i + 1 + ": " + buildings.get(i).toString());
    }
  }
}
