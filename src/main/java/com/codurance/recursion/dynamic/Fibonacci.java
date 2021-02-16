package com.codurance.recursion.dynamic;

import java.time.Duration;
import java.time.Instant;

public class Fibonacci {
  public static void main(String[] args) {

    Instant start = Instant.now();
    System.out.println(fib(30));
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println(timeElapsed);

    Instant secondStart = Instant.now();
    System.out.println(fibCached(1000));
    Instant secondFinish = Instant.now();
    long secondTimeElapsed = Duration.between(secondStart, secondFinish).toMillis();
    System.out.println(secondTimeElapsed);

    Instant thirdStart = Instant.now();
    System.out.println(fibIterative(1000));
    Instant thirdFinish = Instant.now();
    long thirdTimeElapsed = Duration.between(thirdStart, thirdFinish).toMillis();
    System.out.println(secondTimeElapsed);
  }

  public static int fib(int n){
    if (n == 0) return 0;
    if (n == 1) return 1;

    return fib(n - 1) + fib(n - 2);
  }

  public static int fibCached(int n) {
    if (n < 2) return n;
    int[] cache = new int[n+1];
    for(int i = 0; i < cache.length; i++){
      cache[i] = -1;
    }

    cache[0] = 0;
    cache[1] = 1;
    return fibCached(n, cache);
  }

  private static int fibCached(int n, int[] cache) {
    if (cache[n] >= 0) return cache[n];
    cache[n] = fibCached(n - 1, cache) + fibCached(n - 2, cache);
    return cache[n];
  }

  public static int fibIterative(int n) {
    if (n == 0) return 0;

    int[] cache = new int[n + 1];
    cache[1] = 1;

    for (int i = 2; i <= n; i++){
      cache[i] = cache[i - 1] + cache[i - 2];
    }

    return cache[n];
  }
}
