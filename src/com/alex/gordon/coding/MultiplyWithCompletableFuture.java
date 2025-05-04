package com.alex.gordon.coding;

import java.util.concurrent.CompletableFuture;

public class MultiplyWithCompletableFuture {

    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 5);

        // Use thenCombine to multiply the results of the two futures
        // thenCombine ==> independent tasks!!!
        CompletableFuture<Integer> resultFuture = future1.thenCombine(future2, (a, b) -> a * b);

        // Get the result using join()
        Integer result = resultFuture.join();

        System.out.println("Result: " + result); // Output: Result: 50


        // Use thenCompose to multiply the results of the two futures
        // thenCompose ==> dependent tasks!!!
        CompletableFuture<Integer> resultFuture2 = future1.thenCompose(x -> CompletableFuture.supplyAsync(() -> x * 15));


        // Get the result using join()
        Integer result2 = resultFuture2.join();

        System.out.println("Result: " + result2); // Output: Result: 150



    }
}
