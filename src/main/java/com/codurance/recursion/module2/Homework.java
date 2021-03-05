package com.codurance.recursion.module2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
  static ArrayList<Integer> array = new ArrayList<>();

  public static List<Integer> flatten(int[][] arr){
    flattenFirst(arr, 0);

    return array;
  }

  private static void flattenFirst(int[][] arr, int counter){
    flattenSecond(arr, counter, 0);
  }

  private static void flattenSecond(int[][] arr, int counter, int counter2){
    if (counter2 > arr[counter].length){
      return;
    }

    array.add(arr[counter][counter2]);
    flattenSecond(arr, counter, counter2 + 1);
  }
}
