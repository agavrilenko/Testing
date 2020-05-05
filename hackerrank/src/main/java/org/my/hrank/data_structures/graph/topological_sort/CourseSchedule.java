package org.my.hrank.data_structures.graph.topological_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
                return false;
            }

        }
        return true;
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
