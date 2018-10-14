package com.dy.tw.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

  Ship ship1;

  @Before
  public void setUp() {
    ship1 = new Ship("P", 2, 2, "B1");
  }

  @Test
  public void testShipConstructionSections() {
    Assert.assertEquals(ship1.getShipSections().size(), 4);
    Assert.assertTrue(ship1.getShipSections().contains(new ShipSection("B2", 1)));
    Assert.assertTrue(ship1.getShipSections().contains(new ShipSection("C1", 1)));
    Assert.assertTrue(ship1.getShipSections().contains(new ShipSection("C2", 1)));
  }

  @Test
  public void testHandleAttack() {
    Assert.assertTrue(ship1.handleAttack("B1"));
    Assert.assertTrue(ship1.handleAttack("B2"));
    Assert.assertTrue(ship1.handleAttack("C1"));
    Assert.assertFalse(ship1.handleAttack("C3"));
  }
}
