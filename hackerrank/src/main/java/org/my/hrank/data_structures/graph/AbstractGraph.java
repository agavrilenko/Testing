package org.my.hrank.data_structures.graph;

import java.util.Collection;
import java.util.LinkedList;

public abstract class AbstractGraph {

    int cnt;
    LinkedList<Integer>[] vertices;

    public abstract void add(int v, int w);
    public abstract Collection<Integer> adj(int v);
    public abstract int size();
}
