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
public class CourseScheduleTest {
    private List<Integer>[] in;
    private int num;
    private boolean out;

    private CourseSchedule solution;

    public CourseScheduleTest(List<Integer>[] in, int num, boolean out) {
        this.in = in;
        this.num = num;
        this.out = out;
    }

    @Before
    public void init() {
        solution = new CourseSchedule();
    }

    @Parameterized.Parameters
    public static Collection params() {
        return asList(new Object[][]{
                {new List[]{asList(1, 0)}, 2, true},
                {new List[]{asList(0, 1), asList(0, 4), asList(1, 2), asList(1, 3), asList(1, 4), asList(2, 3), asList(3, 4)}, 5, true},
                {new List[]{asList(1, 0), asList(0, 1)}, 2, false},
        });

    }

    @Test
    public void test() {
        Assert.assertEquals(out, solution.canFinish(num, GraphUtils.convertToArray(in)));
    }

}