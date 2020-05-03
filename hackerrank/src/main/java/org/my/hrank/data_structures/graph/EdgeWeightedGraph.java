package org.my.hrank.data_structures.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class EdgeWeightedGraph extends AbstractWeightedGraph {

    private Collection<Edge> edges = new HashSet<>();

    public EdgeWeightedGraph(int cnt) {
        this.cnt = cnt;
        this.vertices = (LinkedList<Edge>[]) new LinkedList[cnt];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new LinkedList<Edge>();
        }
    }

    public void add(Edge e) {
        vertices[e.from()].add(e);
        vertices[e.to()].add(e);
        edges.add(e);
    }

    public Collection<Edge> edges() {
        return edges;
    }

}
