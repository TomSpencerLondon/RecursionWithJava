package com.codurance.recursion;

import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Chapter1 {
  public static void main(String[] args) {
    printNumbers(10);
    print1toN(10);
    System.out.println(factorial(3));
    System.out.println(factorialRecursive(3));

    hanoi(4, 'a', 'b', 'c');

    System.out.println(countEvensInArray(new int[]{1, 2, 3, 4, 5, 6}));

    System.out.println(fibonacci(8));

    printReversedLinkedList(new Node(1, new Node(2, new Node(3, new Node(4, null)))));
    printReversedLinkedListRecursive(new Node(1, new Node(2, new Node(3, new Node(4, null)))));

    System.out.println(combinations(new int[]{1, 2, 3}));
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

  public static void printReversedLinkedListRecursive(Node head){
    if (head == null) return;
    printReversedLinkedListRecursive(head.next);
    System.out.println(head.val);
  }

  public static void printReversedLinkedList(Node head){
    Stack<Node> s = new Stack<Node>();
    while (head != null) {
      s.push(head);
      head = head.next;
    }
    while(!s.isEmpty()){
      System.out.println(s.pop());
    }
  }

  public static List<List<Integer>> combinations(int[] n){
    List<List<Integer>> results = new LinkedList<>();
    combinationsPassed(n, 0, results, new LinkedList<Integer>());
    return results;
  }

  private static void combinationsPassed(int[] n, int i, List<List<Integer>> results, List<Integer> path){
    if (i == n.length){
      results.add(path);
      return;
    }

    List<Integer> pathWithCurrent = new LinkedList<>(path);
    pathWithCurrent.add(n[i]);

    combinationsPassed(n, i+1, results, path);
    combinationsPassed(n, i + 1, results, pathWithCurrent);

  }
}

class Node {
  int val;
  Node next;

  public Node(int val, Node next){
    this.val = val;
    this.next = next;
  }

  public String toString(){
    return val + "";
  }
}
