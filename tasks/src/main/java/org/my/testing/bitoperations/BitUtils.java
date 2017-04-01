package org.my.testing.bitoperations;

/**
 * Created by trash on 20-Mar-17.
 */
public class BitUtils {

    public static int swap(int source, int left, int right) {
        int x = source;
        //test that bits are not equal
        if (((x >>> left) & 1) == ((x >>> right) & 1)) {
            return x;
        }
        // swap: take bits at right and left positions.
        // make OR on them to get bit mask.
        int mask = 1 << left | 1 << right;
        return x ^ mask;

    }

    public static int bitAt(int x, int position) {
        return (x >>> position) & 1;
    }
}
