package week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import week_01.Edge;
import week_01.Graph;

public class PrimsMST implements MST {

    private final List<Edge> edges;
    private double weight;
    private int numOfTrees;

    public PrimsMST(Graph G) {
        this.edges = new ArrayList<Edge>();
        this.weight = 0.0;

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        UF uf = new UF(G.V());

        for (int node = 0; node < G.V(); node++)
            for (Edge e : G.adj(node))
                pq.offer(e);

        int cntEdges = 0;
        while (cntEdges < G.V() - 1 && !pq.isEmpty()) {
            Edge e = pq.poll();
            if (!uf.connected(e.src(), e.dst())) {
                uf.union(e.src(), e.dst());
                weight += e.val();
                edges.add(e);
                cntEdges++;
            }
        }
        this.numOfTrees = uf.count();
    }

    @Override
    public Iterable<Edge> edges() {
        return edges;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public int trees() {
        return numOfTrees;
    }

}
