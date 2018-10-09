package org.my.hrank.data_structures.heap.qheap1;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractTest;

import java.util.Scanner;

public class QheapSolutionTest extends AbstractTest {


    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {

        int numberOfOps = Integer.valueOf(inScanner.nextLine());
        Solution.Heap heap = new Solution.Heap();
        String operations;
        StringBuffer actual = new StringBuffer();
        for (int i = 0; i < numberOfOps; i++) {
            operations = inScanner.nextLine();
            String[] ops = operations.split(" ");
            if (ops[0].equals("3")) {
                actual.append(heap.printMin()).append(" ");
            }
            if (ops[0].equals("2")) {
                heap.delete(Integer.valueOf(ops[1]));
            }
            if (ops[0].equals("1")) {
                heap.insert(Integer.valueOf(ops[1]));
            }
        }
        if (actual.length() > 1) {
            actual = actual.deleteCharAt(actual.length() - 1);
        }
        String expected = outScanner.nextLine();

        collector.checkThat("Test failed for " + absolutePath, actual.toString(), Is.is(expected));

    }
}