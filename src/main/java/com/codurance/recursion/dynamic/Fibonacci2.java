package com.codurance.recursion.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci2 {

  public static void main(String[] args) {

    System.out.println(fib(5));
    System.out.println(fibIterative(5));
  }

  public static int fib(int number){
    Map<Integer, Integer> numbers = new HashMap<>();
    return fib(number, numbers);
  }

  public static int fib(int number, Map<Integer, Integer> numbers){

    if (number == 0){
      return 0;
    }
    if (number == 1 || number == 2){
      return 1;
    }

    Integer integer = numbers.get(number);
    if(integer == null){
      numbers.put(number, fib(number - 1, numbers) + fib(number - 2, numbers));
    }

    return numbers.get(number);
  }

  public static int fibIterative(int number){
    int[] numbers = new int[number];
    numbers[0] = 1;
    numbers[1] = 1;
    for (int i = 2; i < number; i++){
      numbers[i] += numbers[i - 1] + numbers[i - 2];
    }

    return numbers[number - 1];
  }
}
