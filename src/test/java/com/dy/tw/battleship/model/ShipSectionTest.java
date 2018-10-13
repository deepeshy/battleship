package com.dy.tw.battleship.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShipSectionTest {

  ShipSection shipSection1;
  ShipSection shipSection2;

  @Before
  public void setUp() {
    shipSection1 = new ShipSection("A1", 2);
    shipSection2 = new ShipSection("E4", 2);
  }

  @Test
  public void shipSectionConstruction() {

    assertEquals(shipSection1.getRow(), 0);
    assertEquals(shipSection1.getColumn(), 0);

    assertEquals(shipSection2.getRow(), 4);
    assertEquals(shipSection2.getColumn(), 3);
  }

  @Test
  public void handleAttack() {
    shipSection1.handleAttack("A1");
    assertEquals(shipSection1.getLifeCount(), 1);
    shipSection1.handleAttack("A1");
    assertEquals(shipSection1.getLifeCount(), 0);
  }
}
