package org.my.hrank.data_structures.graph;

public class FlowEdge {
    private int v, w;
    private double capacity;
    private double flow;

    public FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double capacity() {
        return capacity;
    }

    public double flow() {
        return flow;
    }

    public int other(int vert) {
        return vert == v ? w : v;
    }

    public double residualCapacityTo(int vert) {
        return vert == v ? flow : capacity - flow;
    }

    public void addResidualFlowTo(int vert, double delta) {
        if (vert == v) {
            flow = -delta;
        } else {
            flow += delta;
        }
    }

}
