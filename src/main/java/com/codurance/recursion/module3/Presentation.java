package com.codurance.recursion.module3;
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
}

//  | | ...|


// 4 - 3 - 2 - 1

// 15

// 2 * (m(2)) + 1

// 2 * (m(1)) + 1 - 3

// isPalindrome - tower of hanoi also.