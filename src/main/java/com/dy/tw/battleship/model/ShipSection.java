package com.dy.tw.battleship.model;

public class ShipSection {

  private final static char FIRST_ROW_ALPHABET = 'A';

  private int row;
  private int column;
  private int lifeCount;

  boolean isDead() {
    return lifeCount == 0;
  }

  // Uses the absolute value of coordinates to create a position
  private ShipSection(int rowInt, int column, int lifeCount) {
    this.row = rowInt;
    this.column = column;
    this.lifeCount = lifeCount;
  }

  ShipSection(String posString, int lifeCount) {
    int[] xy = getCoordinates(posString);
    this.row = xy[0];
    this.column = xy[1];
    this.lifeCount = lifeCount;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public int getLifeCount() {
    return lifeCount;
  }

  ShipSection getRightCellByN(int n) {
    return new ShipSection(row, column + n, this.lifeCount);
  }

  ShipSection getDownByN(int n) {
    return new ShipSection(row + n, column, this.lifeCount);
  }

  boolean handleAttack(String loc) {
    if (this.lifeCount == 0) {
      return false;
    }
    int[] xy = getCoordinates(loc);
    if (xy[0] == row && xy[1] == column) {
      this.lifeCount--;
      return true;
    }
    return false;
  }

  private int[] getCoordinates(String loc) {
    int[] ints = new int[2];
    ints[0] = (int) (Character.toUpperCase(loc.charAt(0))) - FIRST_ROW_ALPHABET;
    ints[1] = Integer.parseInt(String.valueOf(loc.charAt(1))) - 1;
    return ints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ShipSection that = (ShipSection) o;

    if (row != that.row) {
      return false;
    }
    if (column != that.column) {
      return false;
    }
    return lifeCount == that.lifeCount;
  }

  @Override
  public int hashCode() {
    int result = row;
    result = 31 * result + column;
    result = 31 * result + lifeCount;
    return result;
  }

  @Override
  public String toString() {
    return "ShipSection{" +
        "row=" + (char) ((int) row + (int) FIRST_ROW_ALPHABET) +
        ", column=" + (int) ((int) column + 1) +
        '}';
  }
}
