package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class ED implements Comparable<ED> {
		int s, d;
		double w;

		public ED(int src, int dst, double weight) {
			this.s = src;
			this.d = dst;
			this.w = weight;
		}

		@Override
		public int compareTo(ED that) {
			return new Double(this.w).compareTo(that.w);
		}
	}

	static class EI implements Comparable<EI> {
		int prnt, node, w;

		public EI(int src, int dst, int weight) {
			this.prnt = src;
			this.node = dst;
			this.w = weight;
		}

		@Override
		public int compareTo(EI that) {
			return this.w - that.w;
		}
	}

	public static int[] dijkstra(int[][] adj, int S) {
		int numOfNodes = adj.length, OO = 1000000000, numOfVisited = 0;
		boolean[] vist = new boolean[numOfNodes];
		int[] dist = new int[numOfNodes];
		int[] prnt = new int[numOfNodes];

		Arrays.fill(dist, OO);
		Arrays.fill(prnt, -1);

		PriorityQueue<EI> pq = new PriorityQueue<EI>();
		pq.offer(new EI(S, S, 0));
		while (!pq.isEmpty() && numOfVisited < numOfNodes) {
			EI cur = pq.poll();
			if (!vist[cur.node]) {
				dist[cur.node] = cur.w;
				prnt[cur.node] = cur.prnt;
				vist[cur.node] = true;
				numOfVisited++;
				for (int w = 0; w < numOfNodes; w++) {
					if (adj[cur.node][w] < OO && !vist[w]) pq.offer(new EI(
							cur.node, w, dist[cur.node] + adj[cur.node][w]));
				}
			}
		}
		return dist;
	}

	static class E implements Comparable<E> {
		int node, prnt;
		Double w;

		public E(int prnt, int node, double w) {
			this.prnt = prnt;
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(E that) {
			return this.w.compareTo(that.w);
		}
	}

	public static double[] dijkstra(Map<Integer, ArrayList<E>> g, int S) {
		int numOfNodes = g.size(), OO = 1000000000, numOfVisitedNodes = 0;
		double[] dist = new double[numOfNodes];
		int[] prnt = new int[numOfNodes];
		boolean[] vis = new boolean[numOfNodes];

		PriorityQueue<E> pq = new PriorityQueue<E>();
		pq.offer(new E(S, S, 0.0D));

		while (pq.isEmpty() && numOfVisitedNodes < numOfNodes) {
			E cur = pq.poll();
			if (!vis[cur.node]) {
				dist[cur.node] = cur.w;
				prnt[cur.node] = cur.prnt;
				vis[cur.node] = true;
				numOfVisitedNodes++;

				for (E nxt : g.get(cur.node)) {
					if (!vis[nxt.node]) pq.offer(new E(cur.node, nxt.node,
							dist[cur.node] + nxt.w));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine()), N, M, S;
		String[] s;
		int[][] adj;
		while (T-- > 0) {
			s = in.nextLine().split("\\s+");
			N = I(s[0]);
			M = I(s[1]);
			adj = new int[N][N];
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
			S = I(in.nextLine()) - 1;
			int[] dist = dijkstra(adj, S);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++)
				if (i != S) sb.append(dist[i] == 1000000000 ? -1 : dist[i])
						.append(" ");
			System.out.println(sb.toString().trim());
		}

		in.close();
	}
}
