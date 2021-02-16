package com.codurance.recursion.module1;

import java.util.LinkedList;
import java.util.List;

public class Presentation {
  static int globalResult;

  public static void main(String[] args) {
//    countEvenGlobal(new int[]{
//        1, 2, 3, 4, 5, 6
//    });
//
//    System.out.println(globalResult);
//
//    System.out.println(countEvenPassed(new int[]{1, 2, 3, 4, 5, 6}));
//    System.out.println(countEvenBuiltUp(new int[]{1, 2, 3, 4, 5, 6}));
//    System.out.println(fib(5));
//
//    printReversedLinkedList(new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null))))));
    System.out.println(combinations(new int[]{1, 2, 3}));
  }

  public static void countEvenGlobal(int[] arr) {
    globalResult = 0;
    countEvenGlobal(arr, 0);
  }

  private static void countEvenGlobal(int[] arr, int i) {
    if (i >= arr.length) return;
    if (arr[i] % 2 == 0) globalResult++;
    countEvenGlobal(arr, i + 1);
  }

  public static class ResultWrapper {
    int result;
  }

  public static int countEvenPassed(int[] arr) {
    ResultWrapper result = new ResultWrapper();
    result.result = 0;
    countEvenPassed(arr, 0, result);

    return result.result;
  }

  private static void countEvenPassed(int[] arr, int i, ResultWrapper result) {
    if (i >= arr.length) return;
    if (arr[i] % 2 == 0) result.result++;

    countEvenPassed(arr, i+1, result);
  }

  public static int countEvenBuiltUp(int[] arr) {
    return countEvenBuiltUp(arr, 0);
  }

  private static int countEvenBuiltUp(int[] arr, int i) {
    if (i >= arr.length) return 0;
    int result = countEvenBuiltUp(arr, i+1);

    if (arr[i] % 2 == 0) result++;

    return result;
  }

  public static int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  public static void printReversedLinkedList(Node head) {
    if (head == null) return;
    printReversedLinkedList(head.next);
    System.out.println(head.val);
  }

  public static class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }

  public static List<List<Integer>> combinations(int[] n) {
    List<List<Integer>> results = new LinkedList<>();
    combinations(n, 0, results, new LinkedList<Integer>());
    return results;
  }

  public static void combinations(int[] n, int i, List<List<Integer>> results, List<Integer> path) {
    if (i == n.length) {
      results.add(path);
      return;
    }

    List<Integer> pathWithCurrent = new LinkedList<>(path);
    pathWithCurrent.add(n[i]);

    combinations(n, i + 1, results, path);
    combinations(n, i + 1, results, pathWithCurrent);
  }
}