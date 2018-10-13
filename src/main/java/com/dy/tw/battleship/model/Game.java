package com.dy.tw.battleship.model;

public class Game {

  private Player p1;
  private Player p2;
  private StringBuffer commentary = new StringBuffer();

  public Game(Player p1, Player p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  private void addCommentary(String msg) {
    commentary.append(msg);
    commentary.append("\n");
  }

  private boolean playoutAttack(Player attacker, Player defender) {
    if (attacker.hasLost()) {
      addCommentary(defender.getWinningMessage());
      return true;
    }
    if (defender.hasLost()) {
      addCommentary(attacker.getWinningMessage());
      return true;
    }

    if (attacker.getMoves().isEmpty()) {
      addCommentary(attacker.getOutOfMissileMessage());
      return false;
    } else {
      while (attacker.attack(defender, commentary)) {
        if (defender.hasLost()) {
          addCommentary(attacker.getWinningMessage());
          return true;
        }

        if (attacker.getMoves().isEmpty()) {
          addCommentary(attacker.getOutOfMissileMessage());
          return false;
        }
      }
    }
    return false;
  }

  public String play() {
    while (!p1.getMoves().isEmpty() || !p2.getMoves().isEmpty()) {
      if (playoutAttack(p1, p2)) {
        break;
      }
      if (playoutAttack(p2, p1)) {
        break;
      }
    }
    return commentary.toString();
  }
}
