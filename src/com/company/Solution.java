package com.company;


import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            final BigInteger[] result = fix(in.nextBigInteger());
            System.out.println(String.format("Case #%d: %d %d",i, result[0], result[1]));
        }
    }

    private static BigInteger[] fix(final BigInteger input) {
        BigInteger diff = BigInteger.ZERO;
        BigInteger iteration = BigInteger.ONE;

        for (BigInteger i = input; i.compareTo(BigInteger.ZERO) > 0; i = i.divide(BigInteger.valueOf(10))) {
            final BigInteger mod = i.mod(BigInteger.valueOf(10));
            if (mod.compareTo(BigInteger.valueOf(4)) == 0) {
                diff = diff.add(iteration);
            }
            iteration = iteration.multiply(BigInteger.valueOf(10));
        }

        return new BigInteger[]{input.subtract(diff), diff};
    }
}
