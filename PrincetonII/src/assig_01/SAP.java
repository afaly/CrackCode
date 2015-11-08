package assig_01;

import java.util.Map;
import java.util.Scanner;

import edu.princeton.cs.algs4.Digraph;

public class SAP {

	private static final Integer OO = Integer.MAX_VALUE;
	private final Digraph g;

	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		this.g = G;
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		BFSPaths vpath = new BFSPaths(g, v);
		BFSPaths wpath = new BFSPaths(g, w);
		Map<Integer, Integer> vmap = vpath.getAncestors();
		Map<Integer, Integer> wmap = wpath.getAncestors();
		int minDist = OO;
		for (Integer vancestor : vmap.keySet()) {
			Integer vdist = vmap.get(vancestor);
			if (vdist < minDist && wmap.containsKey(vancestor)
					&& vdist + wmap.get(vancestor) < minDist) minDist = vdist
					+ wmap.get(vancestor);
		}
		return minDist < OO ? minDist : -1;
	}

	// a common ancestor of v and w that participates in a shortest ancestral
	// path; -1 if no such path
	public int ancestor(int v, int w) {
		BFSPaths vpath = new BFSPaths(g, v);
		BFSPaths wpath = new BFSPaths(g, w);
		Map<Integer, Integer> vmap = vpath.getAncestors();
		Map<Integer, Integer> wmap = wpath.getAncestors();
		int minDist = OO, minAncestor = -1;
		for (Integer vancestor : vmap.keySet()) {
			Integer vdist = vmap.get(vancestor);
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
		int minDist = OO;
		for (Integer vancestor : vmap.keySet()) {
			Integer vdist = vmap.get(vancestor);
			if (vdist < minDist && wmap.containsKey(vancestor)
					&& vdist + wmap.get(vancestor) < minDist) minDist = vdist
					+ wmap.get(vancestor);
		}
		return minDist < OO ? minDist : -1;
	}

	// a common ancestor that participates in shortest ancestral path; -1 if no
	// such path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		BFSPaths vpath = new BFSPaths(g, v);
		BFSPaths wpath = new BFSPaths(g, w);
		Map<Integer, Integer> vmap = vpath.getAncestors();
		Map<Integer, Integer> wmap = wpath.getAncestors();
		int minDist = OO, minAncestor = -1;
		for (Integer vancestor : vmap.keySet()) {
			Integer vdist = vmap.get(vancestor);
			if (vdist < minDist && wmap.containsKey(vancestor)
					&& vdist + wmap.get(vancestor) < minDist) {
				minDist = vdist + wmap.get(vancestor);
				minAncestor = vancestor;
			}
		}
		return minAncestor;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	// do unit testing of this class
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		int V = I(r.nextLine()), E = I(r.nextLine());
		Digraph g = new Digraph(V);
		for (int i = 0; i < E; i++) {
			String[] s = r.nextLine().trim().split("\\s+");
			g.addEdge(I(s[0]), I(s[1]));
		}
		SAP s = new SAP(g);
		System.out.println(s.length(3, 11) + " throw node : "
				+ s.ancestor(3, 11));
		System.out
				.println(s.length(4, 5) + " throw node : " + s.ancestor(4, 5));

		System.out.println(s.length(10, 11) + " throw node : "
				+ s.ancestor(10, 11));
		r.close();
	}
}
