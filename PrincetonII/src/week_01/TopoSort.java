package week_01;

import java.util.Stack;

public class TopoSort {

	private Stack<Integer> order;

	public Iterable<Integer> Sort(Digraph graph) {
		this.order = new Stack<Integer>();
		DFS(graph, 0, new boolean[graph.V()]);
		return order;
	}

	private void DFS(Graph graph, Integer cur, boolean[] vist) {
		vist[cur] = true;
		for (Edge nxt : graph.adj(cur)) {
			vist[nxt.dst()] = true;
			DFS(graph, nxt.dst(), vist);
		}
		order.push(cur);
	}

}
