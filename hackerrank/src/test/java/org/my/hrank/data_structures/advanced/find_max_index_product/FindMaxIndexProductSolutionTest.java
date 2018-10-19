package org.my.hrank.data_structures.advanced.find_max_index_product;

import org.hamcrest.core.IsEqual;
import org.my.hrank.AbstractTest;

import java.util.Scanner;

import static org.my.hrank.data_structures.advanced.find_max_index_product.Solution.solve;

public class FindMaxIndexProductSolutionTest extends AbstractTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        int arrCount = inScanner.nextInt();
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = inScanner.nextLine().split(" ");
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }


        String line = outScanner.nextLine().trim();
        long expected = Long.parseLong(line);
        long result = solve(arr);
        collector.checkThat(getMessage(absolutePath), result, IsEqual.equalTo(expected));
    }
}