package com.dy.tw.battleship.utils;

public class Utils {

//  public static void main(String[] args) {
//    System.out.println(getCoordinates("A1")[0]);
//    System.out.println(getCoordinates("A1")[1]);
//    System.out.println("A1".charAt(0));
//  }

  public static int[] getCoordinates(String loc) {
//    System.out.println(loc);
//    System.out.println((int) (Character.toLowerCase(loc.charAt(0))) - 65);
//    System.out.println(loc.charAt(1) - 1);
//    System.out.println(loc);
    int[] ints = new int[2];
    try {
      ints[0] = (int) (Character.toUpperCase(loc.charAt(0))) - 65;
      ints[1] = Integer.parseInt(String.valueOf(loc.charAt(1))) - 1;
    } catch (NullPointerException npe) {
      System.out.println("##########"+loc);
    }
    return ints;
  }
}
