package com.codurance.recursion.module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework {

    public static int gcd(int a, int b){
        if (b > a) return gcd(b, a);
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(30, 10));
    }
}
