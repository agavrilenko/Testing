package org.my.hrank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class Dummy {
    static int ret(int v) {
        try {
            throwSurprise(v);
            return 2;
        } catch (Exception e) {
            throw e;
        } finally {
            return 1;
        }
    }

    private static int throwSurprise(int v) {
        if (v > 0) {
            return 3;
        }
        throw new RuntimeException("Yo matherfucker");
    }

    public static BigDecimal extraLongFactorials(int n) {

        BigDecimal res = new BigDecimal("1");
        for (int i = 1; i <= n; i++) {
            res = res.multiply(BigDecimal.valueOf(i));

        }
        return res;
    }

    public static int[] acmTeam(String[] topic) {
        int weight = 0, cnt = 0;
        int len = 0;
        for (int i = 0; i < topic.length - 1; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                len = 0;
                for (int k = 0; k < topic[i].length(); k++) {
                    if (!(topic[i].charAt(k) == '0' && topic[j].charAt(k) == '0')) {
                        len++;
                    }

                }
                if (len > weight) {
                    weight = len;
                    cnt = 1;
                    continue;
                }
                if (len == weight) {
                    cnt++;
                }
            }
        }

        return new int[]{weight, cnt};

    }

    // Complete the taumBday function below.
    static long taumBday(long b, long w, long bc, long wc, long z) {
        BigInteger sum = BigInteger.valueOf(0);

        if (Math.abs(bc - wc) <= z) {
            sum = BigInteger.valueOf(b).multiply(BigInteger.valueOf(bc))
                    .add(BigInteger.valueOf(w).multiply(BigInteger.valueOf(wc)));
        } else {
            if (bc > wc) {
                sum = BigInteger.valueOf(wc).multiply(BigInteger.valueOf(w))
                        .add(BigInteger.valueOf((wc + z)).multiply(BigInteger.valueOf(b)));
            } else {

                sum = BigInteger.valueOf(b).multiply(BigInteger.valueOf(bc))
                        .add(BigInteger.valueOf((bc + z)).multiply(BigInteger.valueOf(w)));
            }
        }

        return sum.longValue();


    }

    public static Long sum(long... args) {
        return Arrays.stream(args).map(i -> i * 2).reduce((x, y) -> x + y).orElse(0L);


    }
}