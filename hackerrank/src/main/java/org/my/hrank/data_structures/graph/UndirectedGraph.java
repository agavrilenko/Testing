package org.my.hrank.data_structures.graph;

import java.util.Collection;
import java.util.LinkedList;

public class UndirectedGraph extends AbstractGraph {


    public UndirectedGraph(int cnt) {
        this.cnt = cnt;
        this.vertices = (LinkedList<Integer>[]) new LinkedList[cnt];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new LinkedList<Integer>();
        }
    }

    public void add(int v, int w) {
        vertices[v].add(w);
        vertices[w].add(v);
    }

    public int size() {
        return cnt;
    }

    public Collection<Integer> adj(int v) {
        return vertices[v];
    }

}
