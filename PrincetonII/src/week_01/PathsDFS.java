package week_01;

import java.util.ArrayList;
import java.util.Stack;

public class PathsDFS implements Paths {

	private final Integer src;
	private Integer[] prnt;

	public PathsDFS(Graph graph, Integer src) {
		this.src = src;
		this.prnt = new Integer[graph.V()];
		DFS(graph, src);
	}

	private void DFS(Graph graph, Integer src) {
		boolean[] vist = new boolean[graph.V()];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(src);
		vist[src] = true;
		while (!stack.isEmpty()) {
			Integer cur = stack.pop();
			for (Edge nxt : graph.adj(cur)) {
				if (!vist[nxt.dst()]) {
					vist[nxt.dst()] = true;
					prnt[nxt.dst()] = cur;
					stack.push(nxt.dst());
				}
			}
		}
	}

	@Override
	public boolean hasPathTo(Integer dst) {
		return dst == src || prnt[dst] != null;
	}

	@Override
	public Iterable<Integer> getPathTo(Integer dst) {
		if (!hasPathTo(dst)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer node = dst; node != src; node = prnt[node])
			stack.push(node);
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(src);
		while (!stack.isEmpty())
			path.add(stack.pop());
		return path;
	}
}
