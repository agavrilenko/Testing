package org.my.hrank.algorithms.implementation.almost_sorted;

import java.util.LinkedList;
import java.util.Scanner;

public class AlmostSortedSolution {
    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        LinkedList<String> results = getResult(arr);
        for (String res : results) {
            System.out.println(res);
        }
    }

    static LinkedList<String> getResult(int[] arr) {
        int lastSorted = 0;
        boolean sorted = true;
        LinkedList<String> result = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[lastSorted] < arr[i]) {
                lastSorted = i;
            } else {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            result.addLast("yes");
            return result;
        }
        int prev = lastSorted;

        for (int i = lastSorted + 1; i < arr.length; i++) {
            if (arr[i] < arr[prev]) {
                prev = i;
            } else {
                break;
            }
        }

        if (prev - lastSorted == 1) {

            swap(arr, prev, lastSorted);
            if (isSorted(arr)) {
                result.addLast("yes");
                result.addLast("swap " + (lastSorted + 1) + " " + (prev + 1));
                return result;
            }
            swap(arr, prev, lastSorted);
            for (int i = prev + 1; i < arr.length; i++) {
                if (arr[prev] < arr[i]) {
                    prev = i;
                } else {
                    prev = i;
                    break;
                }
            }
            swap(arr, prev, lastSorted);
            if (isSorted(arr)) {
                result.addLast("yes");
                result.addLast("swap " + (lastSorted + 1) + " " + (prev + 1));
                return result;
            } else {
                result.addLast("no");
                return result;
            }

            //continue to find next gap
        } else {
            swapRange(arr, prev, lastSorted);
            if (isSorted(arr)) {
                result.addLast("yes");
                result.addLast("reverse " + (lastSorted + 1) + " " + (prev + 1));
                return result;
            } else {
                result.addLast("no");
                return result;
            }
        }
    }

    private static void swapRange(int[] arr, int prev, int lastSorted) {
        for (int i = 0; i < (prev - lastSorted + 1) / 2; i++) {
            swap(arr, lastSorted + i, prev - i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean isSorted(int[] arr) {
        int last = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[last] > arr[i]) {
                return false;
            }
            last = i;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
