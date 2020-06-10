package org.my.hrank.data_structures.graph.all_paths_from_s_to_t;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSToT {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new LinkedList<>();
        int[] pathTo = new int[graph.length];
        Arrays.fill(pathTo, -1);
        pathTo[0] = 0;
        dfs(0, graph, pathTo, list, graph.length - 1);
        return list;
    }

    private void dfs(int to, int[][] graph, int[] pathTo, List<List<Integer>> list, int t) {
        if (to == t) {
            int src = to;
            LinkedList<Integer> print = new LinkedList<>();
            while (pathTo[src] != src) {
                print.addFirst(src);
            src = pathTo[src];
            }
            print.addFirst(src);
            list.add(print);
            return;
        }
        int[] nodes = graph[to];
        for (int i = 0; i < nodes.length; i++) {
            if (pathTo[nodes[i]] != -1) {
                continue;
            }
            pathTo[nodes[i]] = to;
            dfs(nodes[i], graph, pathTo, list, t);
            pathTo[nodes[i]] = -1;
        }
    }
}
