package week_01;

import java.util.HashSet;
import java.util.Iterator;

public class Bag implements Iterable<Edge> {

    private HashSet<Edge> adj;

    public Bag() {
        this.adj = new HashSet<Edge>();
    }

    public boolean add(Edge edge) {
        if (this.adj.contains(edge)) {
            return false;
        } else {
            this.adj.add(edge);
            return true;
        }
    }

    public boolean add(int dst) {
        Edge edge = new Edge(dst);
        if (this.adj.contains(edge)) {
            return false;
        } else {
            this.adj.add(edge);
            return true;
        }
    }

    public boolean add(int dst, double val) {
        Edge edge = new Edge(dst, val);
        if (this.adj.contains(edge)) {
            return false;
        } else {
            this.adj.add(edge);
            return true;
        }
    }

    public int size() {
        return adj.size();
    }

    public void remove(Edge d) {
        adj.remove(d);
    }

    @Override
    public Iterator<Edge> iterator() {
        return adj.iterator();
    }

}