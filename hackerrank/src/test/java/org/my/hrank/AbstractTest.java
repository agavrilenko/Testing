package org.my.hrank;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.my.hrank.data_structures.arrays.left_rotation.LeftRotationSolutionTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public abstract class AbstractTest {

    public abstract void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testSolution() throws Exception {
        this.test();
    }

    public void test() throws Exception {

        String inFolder = "src/test/resources/" + this.getClass().getSimpleName() + "/in";
        URL url = AbstractTest.class.getClassLoader().getResource(inFolder);
        File[] ins = new File(inFolder).listFiles();
//        File[] outs = new File(outFolder).listFiles();
        if (ins == null) {
            Assert.fail();
        }
        for (File inFile : ins) {
            String outFile = inFile.getAbsolutePath().replace(File.separator + "in" + File.separator,
                    File.separator + "out" + File.separator);
            Scanner inScanner = new Scanner(inFile);
            Scanner expData = new Scanner(new File(outFile));

            testAndAssert(inScanner, expData, inFile.getAbsolutePath());
        }

    }

}
