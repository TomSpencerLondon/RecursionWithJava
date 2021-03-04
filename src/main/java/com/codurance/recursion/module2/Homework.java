package com.codurance.recursion.module2;

import java.util.Arrays;

public class Homework {

  public static void main(String[] args) {
//    int[] arr = new int[]{2,4,6,8,10, 12};
//
//    printOdd(arr);

    System.out.println(Arrays.toString(minMax(new int[]{4,6,2,8,1,11,3})));
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

  public static int[] minMax(int[] arr){
    return minMax(arr, 0, Integer.MAX_VALUE, 0);
  }

  private static int[] minMax(int[] arr, int counter, int min, int max){
    if (counter >= arr.length){
      return new int[]{min, max};
    }

    if (min > arr[counter]){
      min = arr[counter];
    }

    if (max < arr[counter]){
      max = arr[counter];
    }

    return minMax(arr, counter + 1, min, max);
  }
}
