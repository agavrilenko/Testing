package org.my.hrank.data_structures.graph.topological_sort;

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
public class CourseScheduleIITest {

    private List<Integer>[] in;
    private int num;
    private int[] out;

    private CourseScheduleII solution;

    public CourseScheduleIITest(List<Integer>[] in, int num, int[] out) {
        this.in = in;
        this.num = num;
        this.out = out;
    }

    @Before
    public void init() {
        solution = new CourseScheduleII();
    }

    @Parameterized.Parameters
    public static Collection params() {
        return asList(new Object[][]{
                {new List[]{asList(1, 0)}, 2, new int[]{0, 1}},
                {new List[]{asList(1, 0), asList(2, 0), asList(3, 1), asList(3, 2)}, 4, new int[]{0, 1, 2, 3}},
                {new List[]{asList(0, 1), asList(0, 4), asList(1, 2), asList(1, 3), asList(1, 4), asList(2, 3), asList(3, 4)}, 5, new int[]{4, 3, 2, 1, 0}},
                {new List[]{asList(1, 0), asList(0, 1)}, 2, new int[]{}},
        });

    }

    @Test
    public void test() {
        Assert.assertArrayEquals(out, solution.findOrder(num, GraphUtils.convertToArray(in)));
    }


}