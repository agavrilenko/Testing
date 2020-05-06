package org.my.hrank.data_structures.graph.topological_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Course schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 */

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        int[] pathTo = new int[graph.length];
        Arrays.fill(pathTo, -1);
        boolean hasCycles = false;
        for (int i = 0; i < graph.length; i++) {
            pathTo[i] = i;
            hasCycles = hasCycles(i, graph, pathTo);
            pathTo[i] = -1;
            if (hasCycles) {
                return new int[]{};
            }

        }

        LinkedList<Integer> order = new LinkedList<>();
        Arrays.fill(pathTo, -1);
        for (int i = 0; i < graph.length; i++) {
            if (pathTo[i] != -1) {
                continue;
            }
            order(i, pathTo, order, graph);
            pathTo[i] = i;

        }


        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private void order(int to, int[] pathTo, LinkedList<Integer> order, List<Integer>[] graph) {

        List<Integer> nodes = graph[to];
        for (int i = 0; i < nodes.size(); i++) {
            if (pathTo[nodes.get(i)] != -1) {
                continue;
            }
            pathTo[nodes.get(i)] = to;
            order(nodes.get(i), pathTo, order, graph);
        }
        order.addLast(to);

    }

    private boolean hasCycles(int to, List<Integer>[] graph, int[] pathTo) {

        List<Integer> nodes = graph[to];
        for (int i = 0; i < nodes.size(); i++) {
            if (pathTo[nodes.get(i)] != -1) {
                return true;
            }
            pathTo[nodes.get(i)] = to;
            boolean has = hasCycles(nodes.get(i), graph, pathTo);
            if (has) {
                return has;
            }
            pathTo[nodes.get(i)] = -1;
        }
        return false;
    }
}
