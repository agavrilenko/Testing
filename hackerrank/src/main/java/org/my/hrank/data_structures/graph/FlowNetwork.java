package org.my.hrank.data_structures.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class FlowNetwork {
    private int V;
    private LinkedList<FlowEdge>[] adj;

    public FlowNetwork(int v) {
        V = v;
        adj = (LinkedList<FlowEdge>[]) new LinkedList[V];
        Arrays.parallelSetAll(adj, i -> new LinkedList<>());

    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    public Collection<FlowEdge> adj(int v) {
        return adj[v];
    }

    public int v(){
        return V;
    }
}
