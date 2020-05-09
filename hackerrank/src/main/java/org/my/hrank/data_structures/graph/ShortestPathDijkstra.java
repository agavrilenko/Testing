package org.my.hrank.data_structures.graph;

import org.my.hrank.data_structures.graph.DirectedWeightedGraph.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dijkstra algo implementation
 */
public class ShortestPathDijkstra {

    DirectedWeightedGraph graph;
    int[] pathTo;
    PriorityQueue<Vertex> pq = new PriorityQueue<>((Vertex o1, Vertex o2) -> {
        if (o1.pathFrom > o2.pathFrom) {
            return -1;
        } else if (o1.pathFrom < o2.pathFrom) {
            return 1;
        } else {
            return 1;
        }
    });


    public void init(DirectedWeightedGraph graph, int s) {
        pathTo = new int[graph.size()];
        Arrays.fill(pathTo, -1);

        pathTo[s] = s;
        graph.get(s).pathFrom = 0;
        pq.add(graph.get(s));

        while (!pq.isEmpty()) {
            Vertex v = pq.remove();
            List<Edge> adj = v.adj();
            for (Edge e : adj) {
                Vertex to = graph.get(e.to());
                if (to.pathFrom > v.pathFrom + e.getWeight()) {
                    pq.remove(to);
                    to.pathFrom = v.pathFrom + e.getWeight();
                    pq.add(to);
                    pathTo[e.to()] = e.from();
                }
            }
        }
    }

    public int[] getPath(int from) {
        ArrayList<Integer> path = new ArrayList<>();
        int next = from;
        while (pathTo[next] != next) {
            path.add(next);
            next = pathTo[next];
        }
        path.add(next);
        return path.stream().mapToInt(Integer::intValue).toArray();
    }

}
