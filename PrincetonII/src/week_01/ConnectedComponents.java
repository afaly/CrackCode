package week_01;

public class ConnectedComponents {

	private final Graph graph;
	private Integer[] cc;
	private Integer mark;

	public ConnectedComponents(final Graph G) {
		this.graph = G;
		this.cc = new Integer[graph.V()];
		this.mark = 0;
		boolean[] vis = new boolean[graph.V()];
		for (int node = 0; node < graph.V(); node++) {
			if (!vis[node]) {
				mark++;
				DFS(node, vis);
			}
		}
	}

	private void DFS(Integer cur, boolean[] vis) {
		vis[cur] = true;
		cc[cur] = mark;
		for (Edge nxt : graph.adj(cur))
			if (!vis[nxt.dst()]) DFS(nxt.dst(), vis);
	}

	public boolean connected(Integer a, Integer b) {
		return cc[a] == cc[b];
	}

	public int count() {
		return mark;
	}

	public int id(Integer a) {
		return cc[a];
	}
}
