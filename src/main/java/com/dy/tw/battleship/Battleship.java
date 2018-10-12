package com.dy.tw.battleship;

// TODO Refactor/Cleanup
// TODO Logic to check if someone won
// TODO Validations
// TODO Testcases

import com.dy.tw.battleship.model.Player;
import com.dy.tw.battleship.model.Ship;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Battleship {

  public static void main(String[] args) {
    // Read the inputs per the specification (except the hits)
    // Set the game up
    // Interpret the moves
    Player p1 = new Player("Player 1");
    Player p2 = new Player("Player 2");
    Scanner scanner = new Scanner(System.in);
    int width = scanner.nextInt();
    String height = scanner.next();
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
    Queue<String> p1Moves = new LinkedList<String>(Arrays.asList(p1MovesInput.split(" ")));
    String p2MovesInput = scanner.nextLine();
    Queue<String> p2Moves = new LinkedList<String>(Arrays.asList(p2MovesInput.split(" ")));

    while (!p1Moves.isEmpty() || !p2Moves.isEmpty()) {
      if (p1Moves.isEmpty()) {
        System.out.println(p1.getName() + " has no more missiles left to fire");
      } else {
        while (p1.attack(p2, p1Moves.poll())) {
          if (p1Moves.isEmpty()) {
            System.out.println(p1.getName() + " has no more missiles left to fire");
          }
          break;
        }
      }

      if (p2Moves.isEmpty()) {
        System.out.println(p2.getName() + " has no more missiles left to fire");

      } else {
        while (p2.attack(p1, p2Moves.poll())) {
          if (p2Moves.isEmpty()) {
            System.out.println(p2.getName() + " has no more missiles left to fire");
            break;
          }
        }
      }
    }

    System.out.println(p1);
    System.out.println(p2);

  }
}
