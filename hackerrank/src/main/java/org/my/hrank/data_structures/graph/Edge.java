package org.my.hrank.data_structures.graph;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    private int from, to;
    private double weight;

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int either() {
        return from;
    }

    public int other(int v) {
        if (this.from == v) {
            return to;
        }
        return from;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.weight) {
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return (from == edge.from && to == edge.to
                || from == edge.to && to == edge.from
        ) && Double.compare(edge.getWeight(), getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, getWeight());
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public double getWeight() {
        return weight;
    }
}
