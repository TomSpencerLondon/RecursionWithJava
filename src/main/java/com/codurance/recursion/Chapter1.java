package com.codurance.recursion;

public class Chapter1 {
  public static void main(String[] args) {
//    printNumbers(10);
    print1toN(10);
//    System.out.println(factorial(3));
//    System.out.println(factorialRecursive(3));

    hanoi(4, 'a', 'b', 'c');

    System.out.println(countEvensInArray(new int[]{1, 2, 3, 4, 5, 6}));

    System.out.println(fibonacci(8));
  }

  public static void printNumbers(int n) {
    for (int counter = 1; counter <= n; counter++) {
      System.out.println(counter);
    }
  }

  public static void print1toN(int n) {
    if (n == 1) {
      System.out.println(1);
    } else {
      System.out.println(n);
      print1toN(n - 1);
    }
  }

  public static int factorial(int n) {
    int result = 1;
    for (int i = n; i > 1; i--) {
      result = i * result;
    }

    return result;
  }

  public static int factorialRecursive(int n) {
    if (n == 1) {
      return 1;
    }

    return n * factorialRecursive(n - 1);
  }

  public static void hanoi(int n, char from, char aux, char dest) {
    if (n == 1) {
      System.out.println(from + " -> " + dest);
    } else {
      hanoi(n - 1, from, dest, aux);
      System.out.println(from + " -> " + dest);
      hanoi(n - 1, aux, from, dest);
    }
  }

  public static int countEvensInArray(int[] arr) {
    return countEvensInArray(arr, 0);
  }

  private static int countEvensInArray(int[] arr, int i) {
    if (i >= arr.length) return 0;
    int result = countEvensInArray(arr, i + 1);

    if (arr[i] % 2 == 0) result++;

    return result;
  }

  public static int fibonacci(int x) {
    if (x <= 0) return 0;
    if (x == 1) return 1;
    return fibonacci(x - 1) + fibonacci(x - 2);
  }
}
