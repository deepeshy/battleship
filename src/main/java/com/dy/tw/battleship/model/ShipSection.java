package com.dy.tw.battleship.model;

import com.dy.tw.battleship.utils.Utils;

public class ShipSection {

  private int row;
  private int column;
  private int lifeCount;
//
//  public ShipSection(char rowChar, int column) {
//    this.row = row - Character.toLowerCase(rowChar) - 65;
//    this.column = column - 1;
//  }

  // Uses the absolute value of coordinates to create a position
  private ShipSection(int rowInt, int column, int lifeCount) {
    this.row = rowInt;
    this.column = column;
    this.lifeCount = lifeCount;
  }

  public ShipSection(String posString, int lifeCount) {
//    this.row = Character.toLowerCase(posString.charAt(0)) - 65;
//    this.column = Integer.parseInt(String.valueOf(posString.charAt(1))) - 1;
    int[] xy = Utils.getCoordinates(posString);
    this.row = xy[0];
    this.column = xy[1];
    this.lifeCount = lifeCount;
  }
//
//  public char getRow() {
//    return (char) (row + 65);
//  }

//  public int getColumn() {
//    return column + 1;
//  }
//
//  public ShipSection getRightCell() {
//    return new ShipSection(row, column + 1);
//  }
//
//  public ShipSection getDown() {
//    return new ShipSection(row + 1, column);
//  }

  public ShipSection getRightCellByN(int n) {
    return new ShipSection(row, column + n, this.lifeCount);
  }

  public ShipSection getDownByN(int n) {
    return new ShipSection(row + n, column, this.lifeCount);
  }

  public boolean handleAttack(String loc) {
    if (this.lifeCount == 0) {
      return false;
    }
    int[] xy = Utils.getCoordinates(loc);
    if (xy[0] == row && xy[1] == column) {
      this.lifeCount--;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "ShipSection{" +
        "row=" + (char) ((int) row + 65) +
        ", column=" + (int) (column + 1) +
        '}';
  }
}
