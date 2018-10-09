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
        private int maxInd = -1;

        int printMin() {
            return values[0];
        }

        void delete(int val) {
            if (values.length == 0) {
                return;
            }
            int delIdx = -1;
            for (int i = 0; i < values.length; i++) {
                if (values[i] == val) {
                    delIdx = i;
                    break;
                }
            }
            if (delIdx == -1) {
                return;
            }

            values[delIdx] = values[maxInd];
            values[maxInd] = 0;
            maxInd--;
            int root = (delIdx - 1) / 2;
            if (values[delIdx] < values[root]) {
                heapify(delIdx);
            } else {
                sinkDown(delIdx);
            }
        }

        private void sinkDown(int delIdx) {
            int leftInd = 2 * delIdx + 1;
            int rightInd = 2 * delIdx + 2;
            if (rightInd > maxInd && leftInd > maxInd) {
                return;
            }

            int min = -1;
            if (leftInd <= maxInd && rightInd <= maxInd) {
                min = values[leftInd] > values[rightInd] ? rightInd : leftInd;
            }
            if (rightInd > maxInd && leftInd < maxInd) {
                min = leftInd;
            }
            if (min != -1 && values[delIdx] > values[min]) {
                int tmp = values[delIdx];
                values[delIdx] = values[min];
                values[min] = tmp;
                sinkDown(min);
            }
        }

        void insert(int value) {
            if (maxInd == -1) {
                values[0] = value;
                maxInd++;
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
