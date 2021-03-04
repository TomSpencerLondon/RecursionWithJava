package com.codurance.recursion.module2;

public class Homework {

  public static void main(String[] args) {
    int[] arr = new int[]{2,4,6,8,10, 12};

    printOdd(arr);
  }

  public static void printOdd(int[] arr) {
    printOdd(arr, 1);
  }

  public static void printOdd(int[] arr, int counter){
    if (counter >= arr.length){
      return;
    }

    System.out.println(arr[counter]);
    printOdd(arr, counter + 2);
  }
}
