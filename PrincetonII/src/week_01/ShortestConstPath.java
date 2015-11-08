package week_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestConstPath {

	private Integer[] dist, prnt;

	public ShortestConstPath(Graph graph, ArrayList<Integer> src) {
		this.dist = new Integer[graph.V()];
		this.prnt = new Integer[graph.V()];
		Arrays.fill(this.dist, Integer.MAX_VALUE);

		boolean[] vist = new boolean[graph.V()];

		Integer hops = 0;

		Queue<Integer> queue = new LinkedList<Integer>();

		for (Integer srcNode : src) {
			queue.add(srcNode);
			dist[srcNode] = 0;
			vist[srcNode] = true;
		}

		while (!queue.isEmpty()) {
			hops++;
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

	public Integer[] getDistances() {
		return dist;
	}

	public Integer getDistanceTo(Integer dst) {
		return dst < dist.length && dst >= 0 ? dist[dst] : Integer.MAX_VALUE;
	}

	public Iterable<Integer> getShortestHopPath(Integer dst) {
		Stack<Integer> st = new Stack<Integer>();
		for (Integer cur = dst; cur != null; cur = prnt[cur])
			st.push(cur);
		ArrayList<Integer> path = new ArrayList<Integer>();
		while (!st.isEmpty())
			path.add(st.pop());
		return path;
	}
}
