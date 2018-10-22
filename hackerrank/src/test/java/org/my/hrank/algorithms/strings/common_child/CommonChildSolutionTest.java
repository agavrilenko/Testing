package org.my.hrank.algorithms.strings.common_child;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractPackageTest;

import java.util.Scanner;

import static org.my.hrank.algorithms.strings.common_child.CommonChildSolution.commonChild;

public class CommonChildSolutionTest extends AbstractPackageTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) {
        String s1 = inScanner.nextLine();

        String s2 = inScanner.nextLine();

        int result = commonChild(s1, s2);
        int expected = Integer.parseInt(outScanner.nextLine().trim());

        collector.checkThat(getMessage(absolutePath), result, Is.is(expected));
    }
}