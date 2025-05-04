package com.alex.gordon.learn.java.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> p1 = i -> i % 2 == 0;
    static Predicate<Integer> p2 = i -> i % 5 == 0;

    public static void main(String[] args) {
        // divisible by 2
        System.out.println("2%2 " + p1.test(2));

        // divisible by 5
        System.out.println("15%5 " + p2.test(15));

        // divisible by 2 AND 5
        System.out.println("50%2 AND %5 " + (p1.test(50) && (p2.test(50)))); // NO predicate chaining
        System.out.println("50%2 AND %5 with chaining " + p1.and(p2).test(50)); //predicate chaining
        System.out.println("15!%2 AND %5 with chaining " + p1.and(p2).test(15)); //predicate chaining

        // divisible by 2 OR 5
        System.out.println("15!%2 OR %5 with chaining " + p1.or(p2).test(15)); //predicate chaining
        System.out.println("16%2 OR %!5 with chaining " + p1.or(p2).test(15)); //predicate chaining
        System.out.println("17!%2 OR %!5 with chaining " + p1.or(p2).test(17)); //predicate chaining

        // NEGATE
        System.out.println("17!%2 OR+NEGATE %!5 with chaining " + p1.or(p2).negate().test(17)); //predicate chaining


    }
}
