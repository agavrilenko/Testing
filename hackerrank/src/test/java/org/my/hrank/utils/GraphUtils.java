package org.my.hrank.utils;

import org.my.hrank.data_structures.graph.DirectedWeightedGraph;
import org.my.hrank.data_structures.graph.Edge;

import java.util.List;

public class GraphUtils {

    public static int[][] convertToArray(List<Integer>[] graph) {
        int[][] source = new int[graph.length][];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null || graph[i].get(0) == null) {
                source[i] = new int[0];
                continue;
            }
            source[i] = new int[graph[i].size()];
            for (int j = 0; j < graph[i].size(); j++) {
                source[i][j] = graph[i].get(j);
            }

        }
        return source;
    }

    public static DirectedWeightedGraph createWeighedDirectedGraph(List<Edge> in, int cnt) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph(cnt);
        for (Edge e : in) {
            graph.add(e);
        }
        return graph;
    }
}
