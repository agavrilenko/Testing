package org.my.hrank.data_structures.trees.tree_huffman_decoding;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.my.hrank.AbstractTest;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.my.hrank.data_structures.trees.tree_huffman_decoding.Solution.buildTree;
import static org.my.hrank.data_structures.trees.tree_huffman_decoding.Solution.printCodes;

public class HuffmanDecodingSolutionTest extends AbstractTest {


    private Map<Character, String> mapA = new HashMap<Character, String>();


    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) {

        String test = inScanner.next();
        Solution.mapA = new HashMap<>();
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray()) {
            charFreqs[c]++;
        }

        // build tree
        Node tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < test.length(); i++) {

            char c = test.charAt(i);
            s.append(Solution.mapA.get(c));

        }

        //System.out.println(s);
        Decoding d = new Decoding();
        String decoded = d.dec(s.toString(), tree);
        String expected = outScanner.next();
        collector.checkThat("Test failed for " + absolutePath, decoded, IsEqual.equalTo(expected));
    }


}