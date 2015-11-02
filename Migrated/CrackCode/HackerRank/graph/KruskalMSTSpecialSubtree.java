package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KruskalMSTSpecialSubtree {

	static class E {
		int src, dst, cst;

		public E(int src, int dst, int cst) {
			this.src = src;
			this.dst = dst;
			this.cst = cst;
		}

		@Override
		public String toString() {
			return "(" + src + ", " + dst + "): " + cst;
		}
	}

	static class N implements Comparable<N> {
		int node, prnt, cost;

		public N(int node, int prnt, int cost) {
			this.node = node;
			this.prnt = prnt;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return node + ":" + cost;
		}

		@Override
		public int compareTo(N that) {
			return this.cost - that.cost;
		}
	}

	public static int MST(int[][] adj, int S) {
		int N = adj.length, OO = 1000000000, totalCost = 0, numOfTakeNodes = 0;

		Map<Integer, ArrayList<E>> mst = new HashMap<Integer, ArrayList<E>>();
		PriorityQueue<N> pq = new PriorityQueue<N>();
		pq.offer(new N(S, S, 0));
		int[] cost = new int[N];
		Arrays.fill(cost, OO);
		cost[S] = 0;
		boolean[] vist = new boolean[N];
		while (numOfTakeNodes < N && !pq.isEmpty()) {
			N cur = pq.poll();
			if (!vist[cur.node]) {
				vist[cur.node] = true;
				numOfTakeNodes++;
				totalCost += cur.cost;

				if (!mst.containsKey(cur.node)) mst.put(cur.node,
						new ArrayList<E>());
				if (cur.node != cur.prnt) mst.get(cur.node).add(
						new E(cur.node, cur.prnt, cur.cost));

				for (int w = 0; w < N; w++) {
					if (adj[cur.node][w] < OO && cost[w] > adj[cur.node][w]) {
						cost[w] = adj[cur.node][w];
						pq.offer(new N(w, cur.node, adj[cur.node][w]));
					}
				}
			}
		}

		return totalCost;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), M = I(s[1]);
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(adj[i], 1000000000);
		for (int i = 0; i < M; i++) {
			s = in.nextLine().split("\\s+");
			int src = I(s[0]) - 1, dst = I(s[1]) - 1, w = I(s[2]);
			if (adj[src][dst] > w) {
				adj[src][dst] = w;
				adj[dst][src] = w;
			}
		}
		int S = I(in.nextLine()) - 1;
		int totalEdgeWeight = MST(adj, S);
		System.out.println(totalEdgeWeight);

		in.close();
	}
}
