package com.dy.tw.battleship;

import com.dy.tw.battleship.model.Game;
import com.dy.tw.battleship.model.Player;
import com.dy.tw.battleship.model.Ship;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Battleship {

  public static void main(String[] args) {
    // Read the inputs per the specification (except the hits)
    // Set the game up
    // Interpret the moves
    Player p1 = new Player("Player-1");
    Player p2 = new Player("Player-2");

    Scanner scanner = new Scanner(System.in);
    int width = scanner.nextInt();
    char height = scanner.next().charAt(0);

    int shipCount = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < shipCount; i++) {
      String shipDetailsRaw = scanner.nextLine();
      String[] shipDetails = shipDetailsRaw.split(" ");

      p1.addShip(new Ship(shipDetails[0], Integer.parseInt(shipDetails[1]),
          Integer.parseInt(shipDetails[2]), shipDetails[3]));
      p2.addShip(new Ship(shipDetails[0], Integer.parseInt(shipDetails[1]),
          Integer.parseInt(shipDetails[2]), shipDetails[4]));
    }

    String p1MovesInput = scanner.nextLine();
    p1.setMoves(new LinkedList<>(Arrays.asList(p1MovesInput.split(" "))));

    String p2MovesInput = scanner.nextLine();
    p2.setMoves(new LinkedList<>(Arrays.asList(p2MovesInput.split(" "))));

    Game g = new Game(p1, p2);
    System.out.println(g.play());
  }
}
