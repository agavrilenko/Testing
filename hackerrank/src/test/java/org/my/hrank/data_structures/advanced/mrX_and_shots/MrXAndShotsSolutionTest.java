package org.my.hrank.data_structures.advanced.mrX_and_shots;

import org.hamcrest.core.IsEqual;
import org.my.hrank.AbstractTest;

import java.util.Scanner;

import static org.my.hrank.data_structures.advanced.mrX_and_shots.Solution.solve;

public class MrXAndShotsSolutionTest extends AbstractTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        String[] nm = inScanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] shots = new int[n][2];

        for (int shotsRowItr = 0; shotsRowItr < n; shotsRowItr++) {
            String[] shotsRowItems = inScanner.nextLine().split(" ");
            inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int shotsColumnItr = 0; shotsColumnItr < 2; shotsColumnItr++) {
                int shotsItem = Integer.parseInt(shotsRowItems[shotsColumnItr]);
                shots[shotsRowItr][shotsColumnItr] = shotsItem;
            }
        }

        int[][] players = new int[m][2];

        for (int playersRowItr = 0; playersRowItr < m; playersRowItr++) {
            String[] playersRowItems = inScanner.nextLine().split(" ");
            inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int playersColumnItr = 0; playersColumnItr < 2; playersColumnItr++) {
                int playersItem = Integer.parseInt(playersRowItems[playersColumnItr]);
                players[playersRowItr][playersColumnItr] = playersItem;
            }
        }

        int result = solve(shots, players);
        int expected = Integer.parseInt(outScanner.nextLine().trim());
        collector.checkThat(getMessage(absolutePath), result, IsEqual.equalTo(expected));
    }
}