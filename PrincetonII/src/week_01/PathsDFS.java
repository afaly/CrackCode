package week_01;

import java.util.ArrayList;
import java.util.Stack;

public class PathsDFS implements Paths {

	private final Graph graph;
	private final Integer src;
	private Integer[] expFrom;

	public PathsDFS(Graph G, Integer src) {
		this.graph = G;
		this.src = src;
		this.expFrom = new Integer[graph.V()];
		DFS(src, new boolean[graph.V()]);
	}

	private void DFS(Integer cur, boolean[] vis) {
		vis[cur] = true;
		for (Edge nxt : graph.adj(cur)) {
			if (!vis[nxt.dst()]) {
				expFrom[nxt.dst()] = cur;
				DFS(nxt.dst(), vis);
			}
		}
	}

	@Override
	public boolean hasPathTo(Integer dst) {
		return dst == src || expFrom[dst] != null;
	}

	@Override
	public Iterable<Integer> getPathTo(Integer dst) {
		if (!hasPathTo(dst)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer node = dst; node != src; node = expFrom[node])
			stack.push(node);
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(src);
		while (!stack.isEmpty())
			path.add(stack.pop());
		return path;
	}
}
