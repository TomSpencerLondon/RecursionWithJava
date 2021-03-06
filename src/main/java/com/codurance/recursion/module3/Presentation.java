package com.codurance.recursion.module3;

import java.util.LinkedList;
import java.util.List;

// Given n disks, find the number of
// moves required to move all the disks
// from position 1 to position 3
// Only one disk can be moved at a time
// A larger disk cannot be placed on top of a smaller disk
// Move the n-1th disks to the aux position,
// then move the largest, then move the n-1th disks again
public class Presentation {
  public static void main(String[] args) {
    System.out.println(moveCount(4));
    hanoi(3, 'a', 'b', 'c');
    System.out.println(isPalindrome("HelloolleH"));
    System.out.println(isPalindromeFor("HelloolleH"));
    System.out.println(stairStep(4));
  }
  // in order to take n disks from 1 - 3 using 2
  // move n - 1 from 1 to 2 using 3
  // move 1 from 1 to 3
  // move n - 1 from 2 to 3 using 1
  public static int moveCount(int n) {
    if (n == 1) return 1;
    System.out.println(n);
    return 2 * moveCount(n - 1) + 1;
  }
                                        //a        b         c
  public static void hanoi(int n, char from, char aux, char dest) {
    if (n == 1) {
      System.out.println(from + " -> " + dest);
    }
    else {
      //            a      c     b
      hanoi(n - 1, from, dest, aux);

      System.out.println(from + " -> " + dest);
      //              b    a      c
      hanoi(n - 1, aux, from, dest);
    }
  }

  //isPalindrome(poop): p == p && isPalindrome(oo)
  // isPalindrome(pollop): p == p && o == o && l == l
  // && true;
  // isPalindrome(holh): h == h && o == l && true;
  public static boolean isPalindrome(String s) {
    if (s.length() <= 1) return true;

    return s.charAt(0) == s.charAt(s.length() - 1)
        && isPalindrome(s.substring(1, s.length() - 1));
  }

  public static boolean isPalindromeFor(String s) {
    if (s.length() == 1)
      return true;

    for (int i = 0; i < s.length(); i++){
      if(s.charAt(i) != s.charAt((s.length() - 1) - i)){
        return false;
      }
    }

    return true;
  }

  public static List<List<Integer>> stairStep(int n){
    return stairStep(n, 0);
  }

  public static List<List<Integer>> stairStep(int n, int currentStep){
    if (currentStep == n){
      List<List<Integer>> result = new LinkedList<List<Integer>>();
      result.add(new LinkedList<Integer>());
      return result;
    }

    if (currentStep > n) {
      return new LinkedList<List<Integer>>();
    }

    List<List<Integer>> result = new LinkedList<List<Integer>>();
    result.addAll(stairStep(n, currentStep + 1));
    result.addAll(stairStep(n, currentStep + 2));
    result.addAll(stairStep(n, currentStep + 3));

    for (List<Integer> l : result){
      l.add(0, currentStep);
    }

    return result;
  }
}
