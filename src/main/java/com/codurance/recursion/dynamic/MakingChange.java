package com.codurance.recursion.dynamic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class MakingChange {
  private static int[] coins = new int[]{1, 5, 10, 25};
  private static int count = -1;

  public static void main(String[] args) {
//    System.out.println(makeChange(1));
    System.out.println(makeChange(6));
    System.out.println(count);
//    System.out.println(makeChange(49));

    var coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
    BigInteger ways = iterativeSolution(coins, 200);
    System.out.println(ways);
  }

  public static int makeChange(int c) {
    if (c == 0) {
      return 0;
    }
    int minCoins = Integer.MAX_VALUE;

    for (int coin : coins) {
      if (c - coin >= 0) {
        int currMinCoins = makeChange(c - coin);
        if (currMinCoins < minCoins) {
          minCoins = currMinCoins;
        }
      }
    }

    return minCoins + 1;
  }

  public static BigInteger[] DPCoins(int[] coins) {
    return Arrays.stream(coins).mapToObj(BigInteger::valueOf).toArray(BigInteger[]::new);
  }

  private static void initializeDP(BigInteger[] coins, int cash) {
    final var SIZE = cash + 1;
    for (var index = 0; index < SIZE; index++) {
      coins[index] = BigInteger.ZERO;
    }
  }

  public static BigInteger iterativeSolution(int[] coins, int cash) {
    // no coins used
    if (cash == 0) {
      return BigInteger.ONE;
    }
    // no cash but coins available
    if (cash < 0) {
      return BigInteger.ZERO;
    }

    // cash available but not coins
    if (cash > 0 && coins.length <= 0) {
      return BigInteger.ZERO;
    }

    var DP = new BigInteger[cash + 1];
    initializeDP(DP, cash);

    var DPCoins = DPCoins(coins);

    final var SIZE = new BigInteger(Long.toString(DP.length));
    DP[0] = BigInteger.ONE;

    for (var coin : DPCoins) {
      for (var x = coin; x.compareTo(SIZE) < 0; x = x.add(BigInteger.ONE)){
        DP[x.intValue()] = DP[x.intValue()].add(DP[(x.subtract(coin)).intValue()]);
      }
    }
    return DP[cash];
  }
}
