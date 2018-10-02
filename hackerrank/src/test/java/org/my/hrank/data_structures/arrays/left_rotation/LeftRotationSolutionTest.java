package org.my.hrank.data_structures.arrays.left_rotation;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.my.hrank.AbstractTest;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeftRotationSolutionTest extends AbstractTest {



    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) {
        String firstLine = inScanner.nextLine();
        String secondLine = inScanner.nextLine();
        String actual = Solution.readAndSolve(firstLine, secondLine);
        String expected = outScanner.nextLine();
//        collector.assertEquals(expected, actual);
        collector.checkThat("Test failed for " + absolutePath, expected, IsEqual.equalTo(actual));
    }

}