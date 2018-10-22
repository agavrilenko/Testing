package org.my.hrank;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public abstract class AbstractTest {


    public abstract void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception;

    public String getMessage(String absolutePath) {
        return "Test failed for " + absolutePath;
    }

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testSolution() throws Exception {
        this.test();
    }

    public void test() throws Exception {

        File[] ins = getTestFiles();
//        File[] outs = new File(outFolder).listFiles();
        if (ins == null) {
            Assert.fail();
        }
        for (File inFile : ins) {
            if (inFile.getAbsolutePath().endsWith("ignore")) {
                continue;
            }
            String outFile = inFile.getAbsolutePath().replace(File.separator + "in" + File.separator,
                    File.separator + "out" + File.separator);
            Scanner inScanner = new Scanner(inFile);
            Scanner expData = new Scanner(new File(outFile));
            testAndAssert(inScanner, expData, inFile.getAbsolutePath());
        }

    }

    protected File[] getTestFiles() {
        String inFolder = "src/test/resources/unpackaged/" + this.getClass().getSimpleName() + "/in";
        URL url = AbstractTest.class.getClassLoader().getResource(inFolder);
        return new File(inFolder).listFiles();
    }

}
