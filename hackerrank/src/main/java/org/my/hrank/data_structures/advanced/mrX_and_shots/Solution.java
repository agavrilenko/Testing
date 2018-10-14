package org.my.hrank.data_structures.advanced.mrX_and_shots;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the solve function below.
    static int solve(int[][] shots, int[][] players) {

        //find max range in shots
        int max = 0;
        for (int[] shot : shots) {
            max = max > shot[0] ? max : shot[0];
            max = max > shot[1] ? max : shot[1];
        }

        int[] left = new int[max + 1];
        int[] right = new int[max + 1];
        for (int[] shot : shots) {
            left[shot[0]]++;
            right[shot[1]]++;
        }

        int[] totalLeft = new int[max + 1];
        int[] totalRight = new int[max + 1];
        int currentLeft = 0;
        int currentRight = 0;
        for (int i = 0; i < max + 1; i++) {
            currentLeft += left[i];
            currentRight += right[i];
            totalLeft[i] = currentLeft;
            totalRight[i] = currentRight;
        }

        //check players
        int sum = 0;
        for (int[] player : players) {
            if (player[0] > max) {
                continue;
            }
            int rightBound = player[1];
            if (rightBound > max) {
                rightBound = max;
            }
            sum += totalLeft[rightBound] - totalRight[player[0] - 1];
        }

        return sum;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] shots = new int[n][2];

        for (int shotsRowItr = 0; shotsRowItr < n; shotsRowItr++) {
            String[] shotsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int shotsColumnItr = 0; shotsColumnItr < 2; shotsColumnItr++) {
                int shotsItem = Integer.parseInt(shotsRowItems[shotsColumnItr]);
                shots[shotsRowItr][shotsColumnItr] = shotsItem;
            }
        }

        int[][] players = new int[m][2];

        for (int playersRowItr = 0; playersRowItr < m; playersRowItr++) {
            String[] playersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int playersColumnItr = 0; playersColumnItr < 2; playersColumnItr++) {
                int playersItem = Integer.parseInt(playersRowItems[playersColumnItr]);
                players[playersRowItr][playersColumnItr] = playersItem;
            }
        }

        int result = solve(shots, players);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}