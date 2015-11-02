package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimMSTSpecialSubtree {

	static class E implements Comparable<E> {
		int node, prnt;
		Integer w;

		public E(int prnt, int node, Integer w) {
			this.prnt = prnt;
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(E that) {
			return this.w.compareTo(that.w);
		}
	}

	static class UF {
		private int[] prnt, rank;
		private int sz, cnt;

		public UF(int size) {
			this.sz = size;
			this.cnt = size;
			this.prnt = new int[sz];
			for (int i = 0; i < sz; i++)
				prnt[i] = i;
			this.rank = new int[sz];
		}

		public int root(int n) {
			if (prnt[n] != n) prnt[n] = root(prnt[n]);
			return prnt[n];
		}

		public boolean same(int a, int b) {
			return root(a) == root(b);
		}

		public int union(int a, int b) {
			int ra = root(a), rb = root(b);
			if (ra == rb) return ra;
			cnt--;
			if (rank[ra] > rank[rb]) {
				prnt[rb] = ra;
				return ra;
			} else if (rank[rb] > rank[ra]) {
				prnt[ra] = rb;
				return rb;
			} else {
				prnt[rb] = ra;
				rank[ra]++;
				return ra;
			}
		}

		public int count() {
			return cnt;
		}
	}

	public static int MST(Map<Integer, ArrayList<E>> g, int S) {
		int N = g.size(), totEdgeWeight = 0;
		ArrayList<E> mst = new ArrayList<E>();
		PriorityQueue<E> pq = new PriorityQueue<E>();
		UF uf = new UF(N);
		for (Integer node : g.keySet())
			for (E edge : g.get(node))
				pq.offer(edge);

		while (!pq.isEmpty() && uf.count() > 1) {
			E cur = pq.poll();
			if (!uf.same(cur.node, cur.prnt)) {
				mst.add(cur);
				totEdgeWeight += cur.w;
				uf.union(cur.node, cur.prnt);
			}
		}

		return totEdgeWeight;
	}

	private static int MST(int[][] adj, int s) {
		int N = adj.length, totEdgeWeight = 0, OO = 1000000000;
		ArrayList<E> mst = new ArrayList<E>();
		PriorityQueue<E> pq = new PriorityQueue<E>();
		UF uf = new UF(N);
		for (Integer n = 0; n < N; n++)
			for (Integer nn = n + 1; nn < N; nn++)
				if (adj[n][nn] < OO) pq.offer(new E(n, nn, adj[n][nn]));

		while (!pq.isEmpty() && uf.count() > 1) {
			E cur = pq.poll();
			if (!uf.same(cur.node, cur.prnt)) {
				mst.add(cur);
				totEdgeWeight += cur.w;
				uf.union(cur.node, cur.prnt);
			}
		}

		return totEdgeWeight;
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
