package com.codurance.recursion;

public class Chapter1 {
  public static void main(String[] args) {
//    printNumbers(10);
//    print1toN(10);
//    System.out.println(factorial(3));
//    System.out.println(factorialRecursive(3));

    hanoi(4, 'a', 'b', 'c');
  }

  public static void printNumbers(int n){
    for (int counter = 1; counter <= n; counter++){
      System.out.println(counter);
    }
  }

  public static void print1toN(int n){
    if (n == 1){
      System.out.println(1);
    }else {
      print1toN(n - 1);
      System.out.println(n);
    }
  }

  public static int factorial(int n){
    int result = 1;
    for (int i = n; i > 1; i--){
      result = i * result;
    }

    return result;
  }

  public static int factorialRecursive(int n){
    if (n == 1){
      return 1;
    }

    return n * factorialRecursive(n - 1);
  }

  public static void hanoi(int n, char from, char aux, char dest){
    if (n == 1){
      System.out.println(from + " -> " + dest);
    } else {
      hanoi(n - 1, from, dest, aux);
      System.out.println(from + " -> " + dest);
      hanoi(n - 1, aux, from, dest);
    }
  }
}
