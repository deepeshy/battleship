package com.dy.tw.battleship.model;

import java.util.ArrayList;
import java.util.List;

public class Ship {

  private int width;
  private int height;
  private ShipType type;
  private List<ShipSection> shipSections = new ArrayList<>();

  public Ship(String type, int width, int height, String position) {
    this.width = width;
    this.height = height;
    // Get the corresponding ShipType based on the string supplied (P/Q), will throw an exception
    // otherwise
    this.type = ShipType.valueOf(type);

    ShipSection currCell = new ShipSection(position, this.type.getHitCount());
    shipSections.add(currCell);
    for (int i = 0; i < height; i++) {
      currCell = currCell.getDownByN(i);
      for (int j = 1; j < width; j++) {
        shipSections.add(currCell.getRightCellByN(j));
      }
    }
  }

  public boolean isDead() {
    return shipSections.stream().allMatch(ShipSection::isDead);
  }

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
