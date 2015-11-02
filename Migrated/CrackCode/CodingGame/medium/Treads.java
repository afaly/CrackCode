package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Treads {
	// O(|V|)
	private static int centerNode(Map<Integer, HashSet<Integer>> graph,
			Map<Integer, Integer> count) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int node : count.keySet()) {
			if (count.get(node) == 1) {
				q.add(node);
			}
		}
		while (q.size() > 1) {
			int node = q.poll();
			for (int parent : graph.get(node)) {
				int numOfNodes = count.get(parent) - 1;
				count.put(parent, numOfNodes);
				if (numOfNodes == 1) {
					q.add(parent);
				}
			}
		}
		return q.poll();
	}

	// O(|E| + |V|)
	private static int bfs(Map<Integer, HashSet<Integer>> graph, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> vis = new HashSet<Integer>();
		q.add(src);
		int time = -1;
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				int node = q.poll();
				if (!vis.contains(node)) {
					vis.add(node);
					for (int nnode : graph.get(node)) {
						if (!vis.contains(nnode)) q.add(nnode);
					}
				}
			}
			time++;
		}
		// System.err.println("Depth : " + time);
		return time;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt(); // the number of adjacency relations

		Map<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();

		int src, dst;
		for (int i = 0; i < M; i++) {
			src = in.nextInt(); // the ID of a person which is adjacent to yi
			dst = in.nextInt(); // the ID of a person which is adjacent to xi

			if (!graph.containsKey(src)) graph.put(src, new HashSet<Integer>());
			if (!graph.containsKey(dst)) graph.put(dst, new HashSet<Integer>());

			graph.get(src).add(dst);
			graph.get(dst).add(src);

			if (!count.containsKey(src)) count.put(src, 1);
			else count.put(src, count.get(src) + 1);

			if (!count.containsKey(dst)) count.put(dst, 1);
			else count.put(dst, count.get(dst) + 1);
		}

		int middleNode = centerNode(graph, count);
		int minTime = bfs(graph, middleNode);
		System.out.println(minTime);

		in.close();
	}
}
