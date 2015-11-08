package week_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathsBFS implements Paths {

	private final Graph graph;
	private final Integer src;
	private Integer[] expFrom;
	private Integer[] hopsFromSrc;

	public PathsBFS(Graph G, Integer src) {
		this.graph = G;
		this.src = src;
		this.expFrom = new Integer[graph.V()];
		this.hopsFromSrc = new Integer[graph.V()];
		Arrays.fill(hopsFromSrc, Integer.MAX_VALUE);
		hopsFromSrc[src] = 0;
		BFS();
	}

	private void BFS() {
		boolean[] vis = new boolean[graph.V()];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		int dist = 0;
		while (!queue.isEmpty()) {
			dist++;
			for (int sz = queue.size(); sz > 0; sz--) {
				Integer cur = queue.poll();
				vis[cur] = true;
				for (Edge nxt : graph.adj(cur)) {
					if (!vis[nxt.dst()]) {
						expFrom[nxt.dst()] = cur;
						hopsFromSrc[nxt.dst()] = dist;
						queue.add(nxt.dst());
					}
				}
			}
		}
	}

	@Override
	public boolean hasPathTo(Integer dst) {
		return src == dst || expFrom[dst] != null;
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

	public Integer numOfHops(Integer dst) {
		return hopsFromSrc[dst];
	}

}
