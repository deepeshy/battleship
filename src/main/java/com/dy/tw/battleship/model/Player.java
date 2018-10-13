package com.dy.tw.battleship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Player {

  private String name;
  private Queue<String> moves;
  private List<Ship> ships = new ArrayList<>();

  public void setMoves(Queue<String> moves) {
    this.moves = moves;
  }

  public Player(String name) {
    this.name = name;
  }

  Queue<String> getMoves() {
    return moves;
  }

  private List<Ship> getShips() {
    return ships;
  }

  public void addShip(Ship s) {
    ships.add(s);
  }

  private String getMessageForAttack(String loc) {
    return this.name + " fires a missile with target " + loc + " which got ";
  }

  String getOutOfMissileMessage() {
    return this.name + " has no more missiles left to launch";
  }

  String getWinningMessage() {
    return this.name + " won the battle";
  }

  boolean attack(Player opposition, StringBuffer commentary) {
    String loc = this.getMoves().poll();
    for (Ship s : opposition.getShips()) {
      if (s.handleAttack(loc)) {
        commentary.append(getMessageForAttack(loc)).append("hit\n");
        return true;
      }
    }
    commentary.append(getMessageForAttack(loc)).append("miss\n");
    return false;
  }

  boolean hasLost() {
    return ships.stream().allMatch(Ship::isDead);
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", ships=" + ships +
        '}';
  }
}
