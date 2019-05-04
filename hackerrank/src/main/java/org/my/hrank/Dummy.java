package org.my.hrank;

import java.math.BigDecimal;

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

    public static  BigDecimal extraLongFactorials(int n){

        BigDecimal res = new BigDecimal("1");
        for(int i = 1; i<=n; i++){
            res = res.multiply(BigDecimal.valueOf(i));

        }
        return res;
    }
}
