package com.dy.tw.battleship.model;

public enum ShipType {
  P(2), Q(1);

  private int hitCount;

  ShipType(int hitCount) {
    this.hitCount = hitCount;
  }

  public int getHitCount() {
    return hitCount;
  }
}
