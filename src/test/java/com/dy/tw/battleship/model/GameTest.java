package com.dy.tw.battleship.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

  Player p1;
  Player p2;

  @Before
  public void setUp() {
    p1 = new Player("Player-1");
    p2 = new Player("Player-2");

    p1.addShip(new Ship("Q", 1, 1, "A1"));
    p2.addShip(new Ship("Q", 1, 1, "B2"));
    p1.addShip(new Ship("P", 2, 1, "D4"));
    p2.addShip(new Ship("P", 2, 1, "C3"));

    Queue<String> p1Moves = new LinkedList<>(Arrays.asList(new String[]{"A1", "B2", "B2", "B3"}));
    Queue<String> p2Moves = new LinkedList<>(
        Arrays.asList(new String[]{"A1", "B2", "B3", "A1", "D1", "E1", "D4", "D4", "D5", "D5"}));
    p1.setMoves(p1Moves);
    p2.setMoves(p2Moves);
  }

  @Test
  public void testPlay() {

    String expectedCommentary = "Player-1 fires a missile with target A1 which got miss\n"
        + "Player-2 fires a missile with target A1 which got hit\n"
        + "Player-2 fires a missile with target B2 which got miss\n"
        + "Player-1 fires a missile with target B2 which got hit\n"
        + "Player-1 fires a missile with target B2 which got hit\n"
        + "Player-1 fires a missile with target B3 which got miss\n"
        + "Player-2 fires a missile with target B3 which got miss\n"
        + "Player-1 has no more missiles left to launch\n"
        + "Player-2 fires a missile with target A1 which got hit\n"
        + "Player-2 fires a missile with target D1 which got miss\n"
        + "Player-1 has no more missiles left to launch\n"
        + "Player-2 fires a missile with target E1 which got miss\n"
        + "Player-1 has no more missiles left to launch\n"
        + "Player-2 fires a missile with target D4 which got hit\n"
        + "Player-2 fires a missile with target D4 which got miss\n"
        + "Player-1 has no more missiles left to launch\n"
        + "Player-2 fires a missile with target D5 which got hit\n"
        + "Player-2 won the battle";
    expectedCommentary = expectedCommentary.trim();
    Game g = new Game(p1, p2);
    Assert.assertEquals(g.play().trim(), expectedCommentary);
  }
}
