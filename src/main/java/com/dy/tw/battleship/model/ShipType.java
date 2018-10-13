package com.dy.tw.battleship.model;

public enum ShipType {
  P(1), Q(2);

  private int hitCount;

  ShipType(int hitCount) {
    this.hitCount = hitCount;
  }

  public int getHitCount() {
    return hitCount;
  }
}
