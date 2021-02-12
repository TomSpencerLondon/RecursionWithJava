package com.codurance.recursion;

public class Chapter1 {
  public static void main(String[] args) {
    printNumbers(10);
    print1toN(10);
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
}
