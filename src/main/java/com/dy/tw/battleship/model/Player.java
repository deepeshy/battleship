package com.dy.tw.battleship.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private String name;
  List<Ship> ships = new ArrayList<Ship>();

  public Player(String name) {
    this.name = name;
  }

  public List<Ship> getShips() {
    return ships;
  }

  public void addShip(Ship s) {
    ships.add(s);
  }

  public String getName() {
    return name;
  }

  public boolean attack(Player opposition, String loc) {
    System.out.print(this.name + " fires a missle with target " + loc + " which got ");
    for (Ship s : opposition.getShips()) {
      if (s.handleAttack(loc)) {
        System.out.print("hit");
        System.out.println();
        return true;
      }
    }
    System.out.print("miss");
    System.out.println();
    return false;
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", ships=" + ships +
        '}';
  }
}
