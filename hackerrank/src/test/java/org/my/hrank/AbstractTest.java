package org.my.hrank;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.my.hrank.data_structures.arrays.left_rotation.LeftRotationSolutionTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public abstract class AbstractTest {

    public abstract void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath);

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    public void test() throws FileNotFoundException {

        String inFolder = "src/test/resources/" + this.getClass().getSimpleName() + "/in";
        URL url = LeftRotationSolutionTest.class.getClassLoader().getResource(inFolder);
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
