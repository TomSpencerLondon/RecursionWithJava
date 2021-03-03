package com.codurance.recursion.module2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Presentation {
  public static void main(String[] args) {
//    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//    printForward(array);
//    printForwardRecursive(array);
//    printBackward(array);
//    printBackwardRecursive(array);
//    sumArray2(new int[]{1, 2, 3});
//
//    Stack stack = new Stack<Integer>();
//    stack.push(1);
//    stack.push(2);
//    stack.push(3);
////    insertToBottom(stack, 0);
////    System.out.println(stack.toString());
//    insertToBottomRecursive(stack, 0);
//    System.out.println(stack.toString());

//    System.out.println(allSubstrings("Hello there!"));
//    System.out.println(substrings("hello"));
    List<String> list = new LinkedList<String>();


    iterateOverSecondCharacters("hello", 0, 0, list);
    iterateOverSecondCharacters("hello", 1, 1, list);
  }

  public static void printForward(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void printBackward(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
      System.out.println(arr[i]);
    }
  }

  public static void printForwardRecursive(int[] arr) {
    printForwardRecursive(arr, 0);
  }

  private static void printForwardRecursive(int[] arr, int i) {
    if (i == arr.length) return;
    System.out.println(arr[i]);
    printForwardRecursive(arr, i + 1);
  }

  public static void printBackwardRecursive(int[] arr) {
    printBackwardRecursive(arr, 0);
  }

  private static void printBackwardRecursive(int[] arr, int i) {
    if (i == arr.length) return;
    printBackwardRecursive(arr, i + 1);
    System.out.println(arr[i]);
  }

  public static int sumArray(int[] arr) {
    return sumArray(arr, 0);
  }

  private static int sumArray(int[] arr, int i) {
    if (i == arr.length) return 0;
    return arr[i] + sumArray(arr, i + 1);
  }

  public static int sumArray2(int[] arr) {
    Result r = new Result();
    sumArray2(arr, 0, r);
    return r.result;
  }

  public static void sumArray2(int[] arr, int i, Result r) {
    System.out.println(r);
    if (i == arr.length) return;
    r.result += arr[i];
    sumArray2(arr, i + 1, r);
  }

  // Insert to the Bottom of the Stack
  public static void insertToBottom(Stack<Integer> stack, int number) {
    Stack<Integer> temp = new Stack<Integer>();

    while (!stack.isEmpty()) {
      Integer element = stack.pop();
      temp.push(element);
    }
    stack.push(number);

    while (!temp.isEmpty()) {
      Integer element = temp.pop();
      stack.push(element);
    }
  }

  public static void insertToBottomRecursive(Stack<Integer> stack, int number) {
    if (stack.isEmpty()) {
      stack.push(number);
      return;
    }
    Integer item = stack.pop();
    insertToBottomRecursive(stack, number);
    stack.push(item);
  }

  public static List<String> allSubstrings(String s) {
    List<String> result = new LinkedList<String>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        result.add(s.substring(i, j));
      }
    }

    return result;
  }
//
//  public static List<String> substrings(String s){
//    List<String> result = new LinkedList<String>();
//
//    return substringsHelper(s, result);
//  }
//
//  private static List<String> substringsHelper(String s, List<String> list){
//    if (s.length() == 0){
//      return list;
//    }
//
//    list.add(s);
//    String substring = s.substring(1);
//    substringsHelper(substring, list);
//    substringsHelper2(substring, list);
//    return list;
//  }
//
//  private static List<String> substringsHelper2(String s, List<String> list) {
//    if (s.length() == 0){
//      return list;
//    }
//
//    list.add(s);
//    String substring = s.substring(1);
//    substringsHelper2(substring, list);
//    return list;
//  }
//
  public static List<String> substrings(String s){
    List<String> result = new LinkedList<String>();
    iterateOverFirstCharacters(s, 0, result);
    return result;
  }

  private static void iterateOverFirstCharacters(String s, int i, List<String> result) {
    if (i >= s.length()) return;
    iterateOverSecondCharacters(s, i, i+ 1, result);
    iterateOverFirstCharacters(s, i + 1, result);
  }

  private static void iterateOverSecondCharacters(String s, int i, int j, List<String> result){
    if (j > s.length()) return;
    result.add(s.substring(i, j));
    System.out.println(s.substring(i, j));
    iterateOverSecondCharacters(s, i, j + 1, result);
  }


  public static class Result {
    int result;
  }
}
