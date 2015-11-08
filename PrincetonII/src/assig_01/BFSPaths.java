package assig_01;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

public class BFSPaths {
	private boolean[] marked;
	private Map<Integer, Integer> ancestors;

	public Map<Integer, Integer> getAncestors() {
		return ancestors;
	}

	/**
	 * Computes the shortest path from <tt>s</tt> and every other vertex in
	 * graph <tt>G</tt>.
	 *
	 * @param G
	 *            the digraph
	 * @param s
	 *            the source vertex
	 */
	public BFSPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		ancestors = new HashMap<Integer, Integer>();
		bfs(G, s);
	}

	/**
	 * Computes the shortest path from any one of the source vertices in
	 * <tt>sources</tt> to every other vertex in graph <tt>G</tt>.
	 *
	 * @param G
	 *            the digraph
	 * @param sources
	 *            the source vertices
	 */
	public BFSPaths(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		ancestors = new HashMap<Integer, Integer>();
		bfs(G, sources);
	}

	// BFS from single source
	private void bfs(Digraph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		marked[s] = true;
		ancestors.put(s, 0);
		q.enqueue(s);
		for (int dist = 1; !q.isEmpty(); dist++) {
			for (int sz = q.size(); sz > 0; sz--) {
				int v = q.dequeue();
				for (int w : G.adj(v)) {
					if (!marked[w]) {
						ancestors.put(w, dist);
						marked[w] = true;
						q.enqueue(w);
					}
				}
			}
		}
	}

	// BFS from multiple sources
	private void bfs(Digraph G, Iterable<Integer> sources) {
		Queue<Integer> q = new Queue<Integer>();
		for (int src : sources) {
			marked[src] = true;
			ancestors.put(src, 0);
			q.enqueue(src);
		}
		for (int dist = 1; !q.isEmpty(); dist++) {
			for (int sz = q.size(); sz > 0; sz--) {
				int v = q.dequeue();
				for (int w : G.adj(v)) {
					if (!marked[w]) {
						ancestors.put(w, dist);
						marked[w] = true;
						q.enqueue(w);
					}
				}
			}
		}
	}

	/**
	 * Is there a directed path from the source <tt>s</tt> (or sources) to
	 * vertex <tt>v</tt>?
	 *
	 * @param v
	 *            the vertex
	 * @return <tt>true</tt> if there is a directed path, <tt>false</tt>
	 *         otherwise
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	/**
	 * Returns the number of edges in a shortest path from the source <tt>s</tt>
	 * (or sources) to vertex <tt>v</tt>?
	 *
	 * @param v
	 *            the vertex
	 * @return the number of edges in a shortest path
	 */
	public int distTo(int v) {
		return ancestors.containsKey(v) ? ancestors.get(v) : Integer.MAX_VALUE;
	}

	/**
	 * Unit tests the <tt>BreadthFirstDirectedPaths</tt> data type.
	 */
	public static void main(String[] args) {}

}
