package week_01;

import java.util.Stack;

public class TopoSort {

	public static Iterable<Integer> Sort(Digraph graph) {
		Stack<Integer> order = new Stack<Integer>();
		DFS(graph, 0, new boolean[graph.V()], order);
		return order;
	}

	private static void DFS(Graph graph, Integer cur, boolean[] vist,
			Stack<Integer> order) {
		vist[cur] = true;
		for (Edge nxt : graph.adj(cur)) {
			vist[nxt.dst()] = true;
			DFS(graph, nxt.dst(), vist, order);
		}
		order.push(cur);
	}
}
