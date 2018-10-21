package org.my.hrank.data_structures.stacks.waiter;

import org.hamcrest.collection.IsArrayContainingInOrder;
import org.my.hrank.AbstractTest;
import org.my.hrank.utils.ArrayUtils;

import java.util.List;
import java.util.Scanner;

import static org.my.hrank.data_structures.stacks.waiter.WaiterSolution.waiter;

public class WaiterSolutionTest extends AbstractTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        String[] nq = inScanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = inScanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] actuals = waiter(number, q);

        List<Integer> expectedList = ArrayUtils.readArray(outScanner.nextLine(), Integer.class);
        Integer[] expected = expectedList.toArray(new Integer[]{});

        Integer[] act = new Integer[actuals.length];
        for (int i = 0; i < actuals.length; i++) {
            act[i] = actuals[i];
        }
        collector.checkThat("Test failed for " + absolutePath, act, IsArrayContainingInOrder.<Object>arrayContaining(expected));

    }
}