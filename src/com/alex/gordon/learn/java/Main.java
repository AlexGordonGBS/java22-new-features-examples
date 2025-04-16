package com.alex.gordon.learn.java;

public class Main {
    public static void main(String[] args) {
        //classic way
        System.out.println("Hello, World! - classic");

        // lambda way
        Runnable myLambda = () -> System.out.println("Hello, World! - lambda");
        myLambda.run();
    }
}

