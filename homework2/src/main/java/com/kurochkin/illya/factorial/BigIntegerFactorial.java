package com.kurochkin.illya.factorial;

import java.math.BigInteger;

public class BigIntegerFactorial {

    public BigInteger factorial (int n) {
        BigInteger result = BigInteger.ONE;

        for(int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    /*
    protected final Map<Integer, BigInteger> cache = new HashMap<>();

    public BigIntegerFactorial() {
        cache.put(0, BigInteger.valueOf(1));
        cache.put(1, BigInteger.valueOf(1));
    }

    public BigInteger factorial(int n) {
        return cache.computeIfAbsent(n, (Integer m) -> factorial(m - 1).multiply(BigInteger.valueOf(m)));
    }
    */
}
