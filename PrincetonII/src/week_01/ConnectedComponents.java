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
			if (!vis[node]) DFS(node, vis, ++mark);
		}
	}

	private void DFS(Integer cur, boolean[] vis, Integer mark) {
		vis[cur] = true;
		for (Edge nxt : graph.adj(cur)) {
			if (!vis[nxt.dst()]) {
				cc[nxt.dst()] = mark;
				DFS(nxt.dst(), vis, mark);
			}
		}
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
