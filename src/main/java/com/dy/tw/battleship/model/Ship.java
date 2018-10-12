package com.dy.tw.battleship.model;

import com.dy.tw.battleship.ShipType;
import java.util.ArrayList;
import java.util.List;

public class Ship {

  private int width;
  private int height;
  private ShipType type;
  private List<ShipSection> shipSections = new ArrayList<ShipSection>();

  public Ship(String type, int width, int height, String position) {
    // TODO Add bunch of validators here to ensure right stuff comes in
    this.width = width;
    this.height = height;
    if (type.equals("Q")) {
      this.type = ShipType.Q;
    }
    if (type.equals("P")) {
      this.type = ShipType.P;
    }

    ShipSection currCell = new ShipSection(position, this.type.getHitCount());
    shipSections.add(currCell);
    for (int i = 0; i < height; i++) {
      currCell = currCell.getDownByN(i);
      for (int j = 0; j < width; j++) {
        shipSections.add(currCell.getRightCellByN(j));
      }
    }
  }

//  public int getWidth() {
//    return width;
//  }
//
//  public int getHeight() {
//    return height;
//  }
//
//  public ShipType getType() {
//    return type;
//  }

  public boolean handleAttack(String loc) {
    for (ShipSection section : shipSections) {
      if (section.handleAttack(loc)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Ship{" +
        "width=" + width +
        ", height=" + height +
        ", type=" + type +
        ", shipSections=" + shipSections +
        '}';
  }
}
