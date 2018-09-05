package org.my.hrank.data_structures.array.left_rotation;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LeftRotationSolutionTest {

    @Test
    public void test() throws FileNotFoundException {

        String inFolder = "src/test/resources/" + this.getClass().getSimpleName() + "/in";
        URL url = LeftRotationSolutionTest.class.getClassLoader().getResource(inFolder);
        File[] ins = new File(inFolder).listFiles();
//        File[] outs = new File(outFolder).listFiles();
        if (ins == null) {
            Assert.fail();
        }
        for (File inFile : ins) {
            Scanner sc = new Scanner(inFile);
            String firstLine = sc.nextLine();
            String secondLine = sc.nextLine();
            String actual = Solution.readAndSolve(firstLine, secondLine);
            String outFile = inFile.getAbsolutePath().replace(File.separator + "in" + File.separator,
                    File.separator + "out" + File.separator);
            Scanner exp = new Scanner(new File(outFile));
            String expected = exp.nextLine();
            Assert.assertEquals(expected, actual);
        }
    }

}