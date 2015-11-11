package assig_01;

import java.util.Map;
import java.util.Map.Entry;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SAP {

    private static final int OO = Integer.MAX_VALUE;
    private final Digraph g;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.g = new Digraph(G);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        BFSPaths vpath = new BFSPaths(g, v);
        BFSPaths wpath = new BFSPaths(g, w);
        Map<Integer, Integer> vmap = vpath.getAncestors();
        Map<Integer, Integer> wmap = wpath.getAncestors();
        int minDist = OO, vancestor, vdist;
        for (Entry<Integer, Integer> entry : vmap.entrySet()) {
            vancestor = entry.getKey();
            vdist = entry.getValue();
            if (vdist < minDist && wmap.containsKey(vancestor)
                    && vdist + wmap.get(vancestor) < minDist) minDist = vdist
                    + wmap.get(vancestor);
        }
        if (minDist < OO) return minDist;
        else return -1;
    }

    // a common ancestor of v and w that participates in a shortest ancestral
    // path; -1 if no such path
    public int ancestor(int v, int w) {
        BFSPaths vpath = new BFSPaths(g, v);
        BFSPaths wpath = new BFSPaths(g, w);
        Map<Integer, Integer> vmap = vpath.getAncestors();
        Map<Integer, Integer> wmap = wpath.getAncestors();
        int minDist = OO, minAncestor = -1, vancestor, vdist;
        for (Entry<Integer, Integer> entry : vmap.entrySet()) {
            vancestor = entry.getKey();
            vdist = entry.getValue();
            if (vdist < minDist && wmap.containsKey(vancestor)
                    && vdist + wmap.get(vancestor) < minDist) {
                minDist = vdist + wmap.get(vancestor);
                minAncestor = vancestor;
            }

        }
        return minAncestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex
    // in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        BFSPaths vpath = new BFSPaths(g, v);
        BFSPaths wpath = new BFSPaths(g, w);
        Map<Integer, Integer> vmap = vpath.getAncestors();
        Map<Integer, Integer> wmap = wpath.getAncestors();
        int minDist = OO, vancestor, vdist;
        for (Entry<Integer, Integer> entry : vmap.entrySet()) {
            vancestor = entry.getKey();
            vdist = entry.getValue();
            if (vdist < minDist && wmap.containsKey(vancestor)
                    && vdist + wmap.get(vancestor) < minDist) minDist = vdist
                    + wmap.get(vancestor);
        }
        if (minDist < OO) return minDist;
        else return -1;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no
    // such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        BFSPaths vpath = new BFSPaths(g, v);
        BFSPaths wpath = new BFSPaths(g, w);
        Map<Integer, Integer> vmap = vpath.getAncestors();
        Map<Integer, Integer> wmap = wpath.getAncestors();
        int minDist = OO, minAncestor = -1, vancestor, vdist;
        for (Entry<Integer, Integer> entry : vmap.entrySet()) {
            vancestor = entry.getKey();
            vdist = entry.getValue();
            if (vdist < minDist && wmap.containsKey(vancestor)
                    && vdist + wmap.get(vancestor) < minDist) {
                minDist = vdist + wmap.get(vancestor);
                minAncestor = vancestor;
            }
        }
        return minAncestor;
    }

    // do unit testing of this class
    public static void main(String[] args) {
        args = new String[2];
        args[0] = "wordnet/synsets3.txt";
        args[0] = "wordnet/hypernyms3InvalidTwoRoots.txt";
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}
