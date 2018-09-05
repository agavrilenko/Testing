package org.my.hrank.data_structures.arrays.left_rotation;

import java.util.Scanner;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String out = readAndSolve(firstLine, secondLine);

        scanner.close();
        System.out.print(out);
    }

    public static String readAndSolve(String firstLine, String secondLine) {
        String[] nd = firstLine.split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = secondLine.split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        return solve(a, d);
    }

    public static String solve(int[] source, int shift) {
        StringBuilder buf = new StringBuilder();

        for (int i = shift; i < source.length; i++) {
            buf.append(source[i]).append(" ");
        }
        for (int i = 0; i < shift; i++) {
            buf.append(source[i]);
            if (i != shift - 1) {
                buf.append(" ");
            }
        }
        return buf.toString();
    }
}
