package org.my.hrank.data_structures.heap.qheap1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        int numberOfOps = inScanner.nextInt();
        Solution.Heap heap = new Solution.Heap();
        String operations;
        for (int i = 0; i < numberOfOps; i++) {
            operations = inScanner.nextLine();
            String[] ops = operations.split(" ");
            if (ops[0] == "3") {
                System.out.println(heap.printMin());
            }
            if (ops[0] == "2") {
                heap.delete(Integer.valueOf(ops[1]));
            }
            if (ops[0] == "1") {
                heap.insert(Integer.valueOf(ops[1]));
            }
        }
    }

    public static class Heap {
        static private int ROOT = 0;
        private int[] values = new int[64];
        private int maxInd = 0;

        int printMin() {
            return values[0];
        }

        void delete(int val) {
            if (values.length == 0) {
                return;
            }
            int ind = -1;
            for (int i = 0; i < values.length; i++) {
                if (values[i] == val) {
                    ind = i;
                }
            }
            if (ind == -1) {
                return;
            }

            values[ind] = values[maxInd];
            values[maxInd] = 0;
            maxInd--;
            int root = (ind - 1) / 2;
            if (values[ind] < values[root]) {
                heapify(ind);
            } else {
                int leftInd = 2 * ind;
                int rightInd = 2 * ind + 1;
//todo continue
            }


        }

        void insert(int value) {
            if (maxInd == 0) {
                values[0] = value;
                return;
            }
            if (values.length == maxInd + 1) {
                doubleHeap();
            }
            int next = maxInd + 1;
            maxInd++;
            values[next] = value;
            heapify(next);
        }

        private void heapify(int next) {
            if (next == 0) {
                return;
            }
            int root = (next - 1) / 2;
            if (values[root] >= values[next]) {
                int tmp = values[root];
                values[root] = values[next];
                values[next] = tmp;
                heapify(root);
            }
        }

        private void doubleHeap() {
            int[] newValues = new int[values.length * 2];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }

    }
}
