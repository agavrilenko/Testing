package org.my.hrank.data_structures.stacks.largest_rectangle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        LinkedList<House> stack = new LinkedList<>();
        House cur = new House(h[0], 0);
        stack.addFirst(cur);
        long s = cur.height;
        House lastViewed = cur;
        long tmp = 0;
        for (int i = 1; i < h.length; i++) {
            cur = new House(h[i], i);
            House lastHigh = stack.peekFirst();
            //going up
            if (lastViewed.height < cur.height) {
                stack.addFirst(cur);
            }
            //doesn't grow
            if (lastViewed.height == cur.height) {
                lastViewed = cur;
            }
            //goes down
            //square should be recalculated when we go down or last element
            if (lastViewed.height > cur.height) {
                lastHigh = stack.pollFirst();

                tmp = lastHigh.height * (cur.position - 1 - lastHigh.position + 1);
                s = tmp > s ? tmp : s;


                //
                if (stack.peekFirst() != null && cur.height == stack.peekFirst().height) {
                    //do nothing
                }
                if (stack.peekFirst() != null && cur.height < stack.peekFirst().height) {
                    while (stack.peekFirst() != null && cur.height < stack.peekFirst().height) {
                        lastHigh = stack.pollFirst();
                        tmp = lastHigh.height * (cur.position - 1 - lastHigh.position + 1);
                        s = tmp > s ? tmp : s;
                    }
                }
                //replace highest with equal to current. use highest as most left house
                if (stack.peekFirst() == null || stack.peekFirst() != null && cur.height > stack.peekFirst().height) {
                    stack.addFirst(new House(cur.height, lastHigh.position));
                }

            }
            //case when last element is highest
            if (cur.position == h.length - 1) {
                while (!stack.isEmpty()) {
                    lastHigh = stack.pollFirst();
                    tmp = lastHigh.height * (cur.position - lastHigh.position + 1);
                    s = tmp > s ? tmp : s;
                }
            }
//            height >= 1 by condition. Otherwise below loop
//            if (cur.height == 0) {
//                while (!stack.isEmpty()) {
//                    lastHigh = stack.pollFirst();
//                    tmp = lastHigh.height * (cur.position - lastHigh.position + 1);
//                    s = tmp > s ? tmp : s;
//                }
//            }

            lastViewed = cur;

        }

        return s;
    }

    public static class House {
        int height;
        int position;

        public House(int height, int position) {
            this.height = height;
            this.position = position;
        }

        @Override
        public String toString() {
            return "House{" +
                    "height=" + height +
                    ", position=" + position +
                    '}';
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
