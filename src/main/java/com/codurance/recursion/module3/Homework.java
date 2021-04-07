package com.codurance.recursion.module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Homework {

    public static int gcd(int a, int b){
        if (b > a) return gcd(b, a);
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(30, 10));
        System.out.println(moves(3));

        boolean[][] squares = new boolean[][]{
            {false, true, false, false},
            {true, true, true, true},
            {false, true, true, false }
        };

        System.out.println(squareSubmatrix(squares));
    }

    public static int squareSubmatrix(boolean[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, squareSubmatrix(arr, i, j));
            }
        }

        return max;
    }

    private static int squareSubmatrix(boolean[][] arr, int i, int j) {
        if (i == arr.length || j == arr[0].length) return 0;
        if (!arr[i][j]) return 0;

        return 1 + Math.min(Math.min(squareSubmatrix(arr, i + 1, j), squareSubmatrix(arr, i, j + 1)), squareSubmatrix(arr, i + 1, j + 1));
    }

    public enum Position {
        SRC { public String toString() { return "SRC"; } },
        DEST { public String toString() { return "DEST"; } },
        AUX { public String toString() { return "AUX"; } };
    }

    public static class Move {
        int disk;
        Position src;
        Position dest;

        public Move(int disk, Position src, Position dest) {
            this.disk = disk;
            this.src = src;
            this.dest = dest;
        }

        public String toString() {
            return "" + disk + " from " + src + " to " + dest;
        }
    }

    public static List<Move> moves(int n) {
        return moves(n, Position.SRC, Position.DEST, Position.AUX);
    }

    private static List<Move> moves(int n, Position src, Position dest, Position aux) {
        if (n == 1) return Arrays.asList(new Move(n, src, dest));

        List<Move> result = new LinkedList<Move>();
        result.addAll(moves(n - 1, src, aux, dest));
        result.add(new Move(n, src, dest));
        result.addAll(moves(n - 1, aux, dest, src));
        return result;
    }

}
