package week_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PathsBFS implements Paths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private Integer[] prnt, dist;

	public PathsBFS(Graph graph, Integer src) {
		this.prnt = new Integer[graph.V()];
		this.dist = new Integer[graph.V()];
		Arrays.fill(dist, INFINITY);
		dist[src] = 0;
		prnt[src] = src;
		BFS(graph, src);
	}

	public PathsBFS(Graph graph, List<Integer> src) {
		this.prnt = new Integer[graph.V()];
		this.dist = new Integer[graph.V()];
		Arrays.fill(dist, INFINITY);
		for (Integer node : src) {
			dist[node] = 0;
			prnt[node] = node;
		}
		BFS(graph, src);
	}

	private void BFS(Graph graph, Integer src) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] vist = new boolean[graph.V()];
		queue.add(src);
		vist[src] = true;
		for (int hops = 1; !queue.isEmpty(); hops++) {
			for (int sz = queue.size(); sz > 0; sz--) {
				Integer cur = queue.poll();
				for (Edge nxt : graph.adj(cur)) {
					if (!vist[nxt.dst()]) {
						vist[nxt.dst()] = true;
						dist[nxt.dst()] = hops;
						prnt[nxt.dst()] = cur;
						queue.add(nxt.dst());
					}
				}
			}
		}
	}

	private void BFS(Graph graph, List<Integer> src) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] vist = new boolean[graph.V()];
		queue.addAll(src);
		for (Integer node : src)
			vist[node] = true;
		for (int hops = 1; !queue.isEmpty(); hops++) {
			for (int sz = queue.size(); sz > 0; sz--) {
				Integer cur = queue.poll();
				vist[cur] = true;
				for (Edge nxt : graph.adj(cur)) {
					if (!vist[nxt.dst()]) {
						prnt[nxt.dst()] = cur;
						dist[nxt.dst()] = hops;
						queue.add(nxt.dst());
					}
				}
			}
		}
	}

	@Override
	public boolean hasPathTo(Integer dst) {
		return prnt[dst] != null;
	}

	@Override
	public Iterable<Integer> getPathTo(Integer dst) {
		if (!hasPathTo(dst)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		Integer node = dst;
		for (; node != prnt[node]; node = prnt[node])
			stack.push(node);
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(node);
		while (!stack.isEmpty())
			path.add(stack.pop());
		return path;
	}

	public Integer numOfHopsTo(Integer dst) {
		return dist[dst];
	}

}
