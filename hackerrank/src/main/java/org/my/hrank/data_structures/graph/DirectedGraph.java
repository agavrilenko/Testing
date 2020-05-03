package org.my.hrank.data_structures.graph;

public class DirectedGraph extends UndirectedGraph {
    public DirectedGraph(int cnt) {
        super(cnt);
    }

    public void add(int v, int w) {
        vertices[v].add(w);
    }
}
