package org.my.hrank.data_structures.arrays.bitwise_and_numbers_range;

public class BitwiseAndOfNumbersRangeSolution {

    public int rangeBitwiseAnd(int m, int n) {
        int depth = n - m;
        int current = m;
        int lastBit = 0;
        int pos = 0;
        int tail = 0;
        //moving one bit from right to left
        while (current > 0) {
            lastBit = current & 1;
            //calculate tail and check weather it is greater than number of elements in range
            tail = lastBit * (int) Math.pow(2, pos) + tail;
            //if tail greater than number of elements it means that major bits will remain same
            if (Math.pow(2, pos + 1) - tail > depth) {
                break;
            }
            pos++;
            //bitwise move to the right.
            current = current >> 1;
        }
        current <<= pos;
        return current & m;
    }

    public int rangeBitwiseAnd1(int m, int n) {
        int[] bin = new int[32];
        int pow = 0;
        int divided = m;
        //binary representation
        while (pow < bin.length) {
            bin[pow] = divided % 2;
            divided = divided / 2;
            pow++;
        }
        //reverse
        for (int i = 0; i < (bin.length) / 2; i++) {
            int tmp = bin[i];
            bin[i] = bin[bin.length - 1 - i];
            bin[bin.length - 1 - i] = tmp;
        }
        //count where we'll have 1's
        //for 101 first 1 will become 0 after 2^3-101 = 3 additions
        //i.e. number of elements should be at least 3 to zero it out.
        //others numbers will 1 in this bit.
        pow = 0;
        int res[] = new int[32];
        int tmp = 0;
        int depth = n - m;
        for (int i = bin.length - 1; i >= 0; i--) {
            if (bin[i] != 0) {
                tmp += Math.pow(2, pow);
                if (Math.pow(2, pow + 1) - tmp > depth) {
                    res[i] = 1;
                }
            } else {
                res[i] = 0;
            }
            pow++;
        }
        pow = 0;
        int sum = 0;
        //calculate final number
        for (int i = res.length - 1; i >= 0; i--) {
            sum += Math.pow(2, pow) * res[i];
            pow++;
        }
        return sum;
    }


}
