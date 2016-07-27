package com.org.labdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by llarios on 7/27/16.
 */
public class SampleFunctionalStyle {


    public static void main(String args[]) {


        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println("is prime " + isPrime(1));
        System.out.println("is prime " + isPrime(2));
        System.out.println("is prime " + isPrime(3));
        System.out.println("is prime " + isPrime(4));
        System.out.println("is prime " + isPrime(5));
        System.out.println("is prime " + isPrime(6));
        System.out.println("is prime " + isPrime(7));


        System.out.println(
        values.stream().filter(e -> e > 3).
                filter(e -> e % 2 ==0 ).
                map(e -> e * 2).
                findFirst().get());


    }

    private static boolean isPrime(final int number) {

        //Predicate<Integer> isDivisible = ( divisor) -> number % divisor ==0;

        return number > 1 && IntStream.range(2, number).
                noneMatch(index -> number % index == 0);
    }


}
