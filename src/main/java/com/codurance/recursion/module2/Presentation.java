package com.codurance.recursion.module2;

import java.util.Stack;

public class Presentation {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    printForward(array);
    printForwardRecursive(array);
    printBackward(array);
    printBackwardRecursive(array);
    sumArray2(new int[]{1, 2, 3});

    Stack stack = new Stack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
//    insertToBottom(stack, 0);
//    System.out.println(stack.toString());
    insertToBottomRecursive(stack, 0);
    System.out.println(stack.toString());
  }

  public static void printForward(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void printBackward(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--){
      System.out.println(arr[i]);
    }
  }

  public static void printForwardRecursive(int[] arr) {
    printForwardRecursive(arr, 0);
  }

  private static void printForwardRecursive(int[] arr, int i){
    if (i == arr.length) return;
    System.out.println(arr[i]);
    printForwardRecursive(arr, i + 1);
  }

  public static void printBackwardRecursive(int[] arr){
    printBackwardRecursive(arr, 0);
  }

  private static void printBackwardRecursive(int[] arr, int i){
    if (i == arr.length) return;
    printBackwardRecursive(arr, i + 1);
    System.out.println(arr[i]);
  }

  public static int sumArray(int[] arr) {
    return sumArray(arr, 0);
  }

  private static int sumArray(int[] arr, int i){
    if ( i == arr.length) return 0;
    return arr[i] + sumArray(arr, i + 1);
  }

  public static class Result {
    int result;
  }

  public static int sumArray2(int[] arr) {
    Result r = new Result();
    sumArray2(arr, 0, r);
    return r.result;
  }

  public static void sumArray2(int[] arr, int i, Result r){
    System.out.println(r);
    if (i == arr.length) return;
    r.result += arr[i];
    sumArray2(arr, i + 1, r);
  }

  // Insert to the Bottom of the Stack
  public static void insertToBottom(Stack<Integer> stack, int number){
    Stack<Integer> temp = new Stack<Integer>();

    while (!stack.isEmpty()) {
      Integer element = stack.pop();
      temp.push(element);
    }
    stack.push(number);

    while(!temp.isEmpty()){
      Integer element = temp.pop();
      stack.push(element);
    }
  }

  public static void insertToBottomRecursive(Stack<Integer> stack, int number) {
    if (stack.isEmpty()){
      stack.push(number);
      return;
    }
    Integer item = stack.pop();
    insertToBottomRecursive(stack, number);
    stack.push(item);
  }
}
