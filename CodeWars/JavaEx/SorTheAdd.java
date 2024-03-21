package com.ems.lunchbe;

import java.util.Arrays;

public class SorTheAdd {


  public static int[] sortArray(int[] array) {

    int[] odds = Arrays
        .stream(array)
        .filter(n -> n % 2 != 0)
        .sorted()
        .toArray();

    int oddsIndex = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] % 2 != 0) {
        array[i] = odds[oddsIndex++];
      }
    }
    return array;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortArray(
        new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
  }

}
