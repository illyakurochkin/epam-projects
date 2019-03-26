package com.kurochkin.illya.factorial;

import java.math.BigInteger;

public class FactorialConsoleApplication {

    public static void main(String[] args) {
        System.out.println("Factorial");
        testMultiThreadFactorial();
        testBigIntegerFactorial();
    }

    private static void testBigIntegerFactorial() {
        System.out.println("BigInteger factorial");

        // 20! = 2432902008176640000
        long startTime = System.currentTimeMillis();
        BigInteger result = new BigIntegerFactorial().factorial(20);
        System.out.println(result);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("2432902008176640000".equals(result.toString()));
        System.out.println("time: " + duration + " ms.\n");
    }

    private static void testMultiThreadFactorial() {
        System.out.println("MultiThreadFactorial");

        // 20! = 2432902008176640000
        long startTime = System.currentTimeMillis();
        BigInteger result = new MultiThreadFactorial().factorial(20);
        System.out.println(result);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("2432902008176640000".equals(result.toString()));
        System.out.println("time: " + duration + " ms.\n");
    }

}
