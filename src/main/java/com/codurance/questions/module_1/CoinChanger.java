package com.codurance.questions.module_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class CoinChanger {
  /*
   *   Title: Coin change
   *
   *   Problem: You are given coins of different denominations and a total amount
   *   of money amount. Write a function to compute the fewest number of coins
   *   that you need to make up that amount. If that amount of money cannot be
   *   made up by any combination of the coins, return -1.
   *
   *   Execution: javac XX && java XX
   */


  public static void main(String[] args) {
    int[] coins = new int[]{2, 5, 10, 50, 100};
    System.out.println(changeMaker(coins, 48));
  }

  private static int changeMaker(int[] coins, int amount) {
    int numberOfCoins = 0;
    for (int i = coins.length - 1; i >= 0; i -= 1){
      if (coins[i] <= amount){
        amount -= coins[i];
        numberOfCoins += 1;
        i++;
      }
    }

    return numberOfCoins;
  }
}
