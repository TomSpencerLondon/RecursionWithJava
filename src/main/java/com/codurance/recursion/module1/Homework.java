package com.codurance.recursion.module1;

import java.util.LinkedList;
import java.util.List;

public class Homework {
  public static void main(String[] args) {
    System.out.println(f1(5));
    System.out.println(f2(4));
    System.out.println(f3(new int[]{1, 2, 3}));
    System.out.println(f4(2, 6));
  }

  public static int f1(int N) {
    if (N < 0) return 0;
    if (N == 0) return 1;
    return f1(N - 1) + f1(N - 2) + f1(N - 3);
  }

  public static int f2(int N) {
    if (N <= 1) return 1;
    int total = 0;
    for (int i = 0; i < N; i++) {
      total += f2(i) * f2(N - i - 1);
    }
    return total;
  }

  public static List<List<Integer>> f3(int[] n) {
    return f3(n, 0);
  }

  private static List<List<Integer>> f3(int[] n, int i) {
    if (i == n.length) {
      List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
      toReturn.add(new LinkedList<Integer>());
      return toReturn;
    }

    List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
    for (List<Integer> result : f3(n, i + 1)) {
      toReturn.add(new LinkedList<Integer>(result));
      result.add(0, n[i]);
      toReturn.add(new LinkedList<Integer>(result));
    }

    return toReturn;
  }

  public static int f4(int n, int m) {
    if (m == 0) return 0;
    if (m == 1) return 1;
    if (n == 1) return m;

    int max = Integer.MAX_VALUE;
    for (int i = 1; i <= m; i++) {
      int case1 = f4(n - 1, i - 1);
      int case2 = f4(n, m - i);
      max = Math.min(max, Math.max(case1, case2));
    }

    return max + 1;
  }
}
