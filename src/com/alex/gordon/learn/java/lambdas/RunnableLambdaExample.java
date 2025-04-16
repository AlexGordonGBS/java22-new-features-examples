package com.alex.gordon.learn.java.lambdas;

public class RunnableLambdaExample {
    public static void main(String[] args) {

        /**
         * prior Java 8
         */
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };
        new Thread(runnable1).start();

        /**
         * java 8 lambda
         * ()->{};
         */
        Runnable runnableLambda = () -> {
            System.out.println("Inside RunnableLambda");
        };
        Runnable runnableLambda1 = () -> {
            System.out.println("Inside RunnableLambda1 -  line 1");
            System.out.println("Inside RunnableLambda1 -  line 2");
        };

        new Thread(runnableLambda).start();
        new Thread(runnableLambda1).start();
        new Thread(() -> System.out.println("inside Runnable 4")).start();



    }
}
