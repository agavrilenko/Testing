package org.my.hrank.data_structures.stacks.waiter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WaiterSolution {
    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {

        List<Integer> primeNumbers = findNthPrimeNumber(q);
        LinkedList<Integer>[] stacks = (LinkedList<Integer>[]) new LinkedList[q + 1];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new LinkedList<>();
        }

        for (int j = number.length - 1; j >= 0; j--) {
            int num = number[j];
            for (int i = 0; i < q; i++) {
                Integer prime = primeNumbers.get(i);
                if (num % prime == 0) {
                    if (i % 2 == 0) {
                        stacks[i].addFirst(num);
                    } else {
                        stacks[i].addLast(num);
                    }
                    break;
                }
                if (i == q - 1) {
                    if (q % 2 == 0) {
                        stacks[q].addLast(num);
                    } else {
                        stacks[q].addFirst(num);

                    }
                }
            }
        }

        LinkedList<Integer> consolidated = new LinkedList<>();
        for (LinkedList list : stacks) {
            consolidated.addAll(list);
        }
        int[] result = new int[consolidated.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = consolidated.removeFirst();

        }

        return result;

    }

    public static List<Integer> findNthPrimeNumber(Integer nthNumber) {
        List<Integer> primeList = new ArrayList<>();
        primeList.addAll(Arrays.asList(2, 3));
        Integer initializer = 4;
        while (primeList.size() < nthNumber) {
            if (isPrime(initializer, primeList)) {
                primeList.add(initializer);
            }
            initializer++;
        }
        return primeList;
    }

    public static Boolean isPrime(Integer input, List<Integer> primeList) {
        return !(primeList.parallelStream().anyMatch(i -> input % i == 0));
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
