package org.my.hrank.data_structures.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DirectedWeightedGraph {

    private Vertex[] vertices;
    private int size;

    public DirectedWeightedGraph(int size) {
        vertices = new Vertex[size];
        this.size = size;
        Arrays.parallelSetAll(vertices, i -> new Vertex());
    }

    public int size() {
        return size;
    }

    public void add(Edge e) {
        vertices[e.from()].add(e);
    }

    public List<Edge> adj(int i) {
        return vertices[i].edges;
    }

    public Vertex get(int n) {
        return vertices[n];
    }

    public static class Vertex {
        List<Edge> edges = new LinkedList<>();
        double pathFrom = Double.POSITIVE_INFINITY;

        public void add(Edge e) {
            edges.add(e);
        }

        public List<Edge> adj() {
            return edges;
        }


    }

}
