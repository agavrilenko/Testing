package org.my.hrank.data_structures.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.my.hrank.utils.GraphUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ShortestPathDijkstraTest {
    private List<Edge> in;
    private int cnt;
    private int to;
    private int from;
    private int[] out;
    private ShortestPathDijkstra solution;

    public ShortestPathDijkstraTest(List<Edge> in, int cnt, int from, int to, int[] out) {
        this.in = in;
        this.cnt = cnt;
        this.to = from;
        this.from = to;
        this.out = out;
    }

    @Before
    public void init() {
        solution = new ShortestPathDijkstra();
    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {Arrays.<Edge>asList(new Edge(0, 1, 5), new Edge(0, 4, 9),
                        new Edge(0, 7, 8), new Edge(1, 2, 12), new Edge(1, 3, 15),
                        new Edge(1, 7, 4), new Edge(2, 3, 3), new Edge(2, 6, 11),
                        new Edge(3, 6, 9), new Edge(4, 5, 4), new Edge(4, 6, 20),
                        new Edge(4, 7, 5), new Edge(5, 2, 1), new Edge(5, 6, 13),
                        new Edge(7, 5, 6), new Edge(7, 2, 7)), 8, 0, 6, new int[]{6, 2, 5, 4, 0}},
                {Arrays.asList(new Edge(0, 1, 1), new Edge(0, 4, 10), new Edge(1, 2, 1),
                        new Edge(1, 4, 6), new Edge(1, 3, 3), new Edge(2, 3, 1),
                        new Edge(3, 4, 1)), 5, 0, 4, new int[]{4, 3, 2, 1, 0}}
        });
    }

    @Test
    public void test() {
        solution.init(GraphUtils.createWeighedDirectedGraph(in, cnt), to);
        Assert.assertArrayEquals(out, solution.getPath(from));
    }


}