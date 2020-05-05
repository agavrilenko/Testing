package org.my.hrank.data_structures.graph.all_paths_from_s_to_t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.my.hrank.utils.GraphUtils;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class AllPathsFromSToTTest {
    private List<Integer>[] in;
    private List<List<Integer>> out;
    AllPathsFromSToT solution;

    public AllPathsFromSToTTest(List[] in, List<List<Integer>> out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void init() {
        solution = new AllPathsFromSToT();

    }


    @Parameterized.Parameters(name = "{1}")
    public static Collection params() {

        return asList(new Object[][]{
                {new List[]{asList(1, 2), asList(3), asList(3), null}, asList(asList(0, 1, 3), asList(0, 2, 3))},
                {new List[]{asList(1, 4), asList(2, 3, 4), asList(3), asList(4), null}, asList(asList(0, 4), asList(0, 1, 4), asList(0, 1, 3, 4), asList(0, 1, 2, 3, 4))},

        });

    }

    @Test
    public void test() {

        List<List<Integer>> actual = solution.allPathsSourceTarget(GraphUtils.convertToArray(in));
        Assert.assertEquals(out.size(), actual.size());
        for (List act : actual) {
            Assert.assertTrue(String.format("out is %s act is %s", out, act), out.contains(act));
        }
    }

}