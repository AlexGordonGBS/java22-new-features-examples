package com.alex.gordon.learn.java.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        /**
         * prior Java 8
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> o1==o2
                                         // 1 -> o1>o2
                                         // -1 -> o1<o2
            }
        };
        System.out.println("Result of comparator (3,2) is :" + comparator.compare(3, 2));
        System.out.println("Result of comparator (3,3) is :" + comparator.compare(3, 3));
        System.out.println("Result of comparator (3,5) is :" + comparator.compare(3, 5));

        /**
         * lambda way - Java 8+
         */
        Comparator<Integer> lambdaComparator = (Integer a, Integer b) -> a.compareTo(b);
        System.out.println("Result of lambdaComparator (3,2) is :" + lambdaComparator.compare(3, 2));
        System.out.println("Result of lambdaComparator (3,3) is :" + lambdaComparator.compare(3, 3));
        System.out.println("Result of lambdaComparator (3,5) is :" + lambdaComparator.compare(3, 5));

        Comparator<Integer> lambdaComparator1 = (a, b) -> a.compareTo(b);
        System.out.println("Result of lambdaComparator1 (3,2) is :" + lambdaComparator1.compare(3, 2));
        System.out.println("Result of lambdaComparator1 (3,3) is :" + lambdaComparator1.compare(3, 3));
        System.out.println("Result of lambdaComparator1 (3,5) is :" + lambdaComparator1.compare(3, 5));

    }
}
