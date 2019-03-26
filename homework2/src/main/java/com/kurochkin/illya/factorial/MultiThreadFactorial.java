package com.kurochkin.illya.factorial;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class MultiThreadFactorial extends BigIntegerFactorial {

    @Override
    public BigInteger factorial(int n) {
        if(n <= 1) {
            return BigInteger.ONE;
        }

        return IntStream.range(2, n + 1)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();
    }
}
