package week_01;

public class Digraph implements Graph {

	private Bag[] graph;
	private final int V;
	private int E;

	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		this.graph = new Bag[V];
		for (int i = 0; i < V; i++)
			graph[i] = new Bag();
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public void addEdge(int src, int dst) {
		if (this.graph[src].add(dst)) E++;
	}

	@Override
	public void addEdge(int src, int dst, double val) {
		if (this.graph[src].add(dst, val)) E++;
	}

	@Override
	public Iterable<Edge> adj(int src) {
		return this.graph[src];
	}

	@Override
	public int OutDegree(int src) {
		return this.graph[src].size();
	}

	@Override
	public int InDegree(int src) {
		return 0;
	}

	@Override
	public Graph reverse() {
		Graph r = new Digraph(V());
		for (Integer n = 0; n < V(); n++) {
			for (Edge e : adj(n)) {
				r.addEdge(e.dst(), n, e.val());
			}
		}
		return r;
	}
}
