package org.my.hrank.algorithms.strings.group_anagrams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GroupAnagramSolutionTest {

    GroupAnagramSolution solution = new GroupAnagramSolution();

    @Test
    public void test() {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> out = Arrays.asList(Arrays.asList("ate", "eat", "tea"), Arrays.asList("nat", "tan"), Arrays.asList("bat"));
        Assert.assertEquals(out, solution.groupAnagrams(strs));

    }

}