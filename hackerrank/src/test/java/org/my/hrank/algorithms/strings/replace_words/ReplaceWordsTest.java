package org.my.hrank.algorithms.strings.replace_words;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class ReplaceWordsTest {
    private ReplaceWords solution = new ReplaceWords();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery", "the cat was rat by the bat"},
        };
    }

    @Test
    @UseDataProvider("data")
    public void test(List<String> dict, String sentence, String expected) {
        Assert.assertEquals(expected, solution.replaceWords(dict, sentence));
    }

}