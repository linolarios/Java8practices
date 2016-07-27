package com.org.labdas;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by llarios on 7/27/16.
 */
public class SampleFunctionalStyle {


    public static void main(String args[]) {


        System.out.println("is prime " + isPrime(1));
        System.out.println("is prime " + isPrime(2));
        System.out.println("is prime " + isPrime(3));
        System.out.println("is prime " + isPrime(4));
        System.out.println("is prime " + isPrime(5));
        System.out.println("is prime " + isPrime(6));
        System.out.println("is prime " + isPrime(7));


    }

    private static boolean isPrime(final int number) {

        //Predicate<Integer> isDivisible = ( divisor) -> number % divisor ==0;

        return number > 1 && IntStream.range(2, number).
                noneMatch(index -> number % index == 0);
    }


}
