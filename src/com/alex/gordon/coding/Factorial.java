package com.alex.gordon.coding;

import java.util.stream.LongStream;

public class Factorial {

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        int number = 5;
        long factorial = calculateFactorial(number);
        System.out.println("The factorial of " + number + " is " + factorial);
    }
}