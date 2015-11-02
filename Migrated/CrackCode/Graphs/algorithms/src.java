package algorithms;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class src {

	static class N implements Comparable<N> {
		int i, p;
		double s;

		public N(int prnt, int id, double score) {
			this.p = prnt;
			this.i = id;
			this.s = score;
		}

		public N(int id, double score) {
			this.i = id;
			this.s = score;
		}

		@Override
		public int compareTo(N n) {
			return Math.abs(s - n.s) < 1e-10D ? 0 : s - n.s < 0 ? -1 : 1;
		}

	}

	static class E implements Comparable<E> {
		int s, d;
		double w;

		public E(int src, int dst, double weight) {
			this.s = src;
			this.d = dst;
			this.w = weight;
		}

		public E(int dst, double weight) {
			this.s = -1;
			this.d = dst;
			this.w = weight;
		}

		@Override
		public String toString() {
			return s + "-->" + d + "  : " + w;
		}

		@Override
		public int compareTo(E e) {
			return Math.abs(w - e.w) < 1e-10D ? 0 : w - e.w < 0 ? -1 : 1;
		}
	}

	public static double[] Dijkstra(Map<Integer, ArrayList<E>> g, int src) {
		int S = g.size(), OO = 1000000000;
		double[] dist = new double[S];
		int[] prnt = new int[S];
		Arrays.fill(dist, OO);
		Arrays.fill(prnt, -1);
		PriorityQueue<E> pq = new PriorityQueue<E>(S);
		pq.offer(new E(src, src, 0));
		while (!pq.isEmpty()) {
			E node = pq.poll();
			if (dist[node.d] > node.w) {
				dist[node.d] = node.w;
				prnt[node.d] = node.s;
				for (E e : g.get(node.d))
					if (dist[e.d] > dist[e.s] + e.w) pq.offer(new E(e.s, e.d,
							node.w + e.w));
			}
		}
		return dist;
	}

	public static double[] BellmanFord(Map<Integer, ArrayList<E>> g, int src) {
		int S = g.size(), OO = 1000000000;
		double[] dist = new double[S];
		int[] prnt = new int[S];
		Arrays.fill(dist, OO);
		Arrays.fill(prnt, -1);
		dist[src] = 0;
		prnt[src] = src;
		boolean negCycle = false;
		for (int k = 0; k < S; k++) {
			negCycle = false;
			for (Integer n : g.keySet()) {
				for (E e : g.get(n)) {
					if (dist[e.d] > dist[e.s] + e.w) {
						negCycle = true;
						dist[e.d] = dist[e.s] + e.w;
						prnt[e.d] = e.s;
					}
				}
			}
		}
		return negCycle ? null : dist;
	}

	public static Object[] BF(Map<Integer, ArrayList<E>> g, int src) {
		int sz = g.size();
		Integer[] prnt = new Integer[sz];
		Double[] dist = new Double[sz];
		Arrays.fill(prnt, null);
		Arrays.fill(dist, 1000000000D);
		dist[src] = 0D;
		prnt[src] = src;
		boolean cycle = false;
		for (int i = 0; i < sz; i++) {
			cycle = false;
			for (Integer n : g.keySet()) {
				for (E e : g.get(n)) {
					if (dist[e.d] > dist[e.s] + e.w) {
						dist[e.d] = dist[e.s] + e.w;
						prnt[e.d] = e.s;
						cycle = true;
					}
				}
			}
		}

		return cycle ? null : new Object[] { dist, prnt };
	}

	public static Object[] DK(Map<Integer, ArrayList<E>> g, int src) {
		int sz = g.size();
		Double[] dist = new Double[sz];
		Integer[] prnt = new Integer[sz];
		Arrays.fill(dist, 10000000000D);
		Arrays.fill(prnt, null);
		PriorityQueue<N> pq = new PriorityQueue<N>();
		pq.offer(new N(src, src, 0));
		while (!pq.isEmpty() && sz > 0) {
			N node = pq.poll();
			if (dist[node.i] > node.s) {
				dist[node.i] = node.s;
				prnt[node.i] = node.p;
				for (E e : g.get(node.i))
					if (dist[e.d] > dist[e.s] + e.w) pq.offer(new N(e.s, e.d,
							dist[e.s] + e.w));
			}
		}
		System.out.println("SIZE: " + sz + " | " + pq.size());
		return new Object[] { dist, prnt };
	}

	public static double[][] FW(Map<Integer, ArrayList<E>> g) {
		int sz = g.size();
		double[][] dist = new double[sz][sz];
		for (int i = 0; i < sz; i++) {
			for (int j = 0; j < sz; j++)
				dist[i][j] = 1000000000;
			for (E e : g.get(i))
				dist[i][e.d] = e.w;
			dist[i][i] = 0;
		}
		for (int k = 0; k < sz; k++) {
			for (int i = 0; i < sz; i++) {
				for (int j = 0; j < sz; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		return dist;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static double D(String s) {
		return Double.parseDouble(s);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Map<Integer, ArrayList<E>> g = new HashMap<Integer, ArrayList<E>>();
		// Scanner in = new Scanner(new File("data/cp/SMALL.txt"));
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), M = I(s[1]); // start = I(s[2]);

		for (int i = 0; i < N; i++)
			g.put(i, new ArrayList<E>());
		for (int i = 0; i < M; i++) {
			s = in.nextLine().trim().split("\\s+");
			g.get(I(s[0]) - 1).add(new E(I(s[0]) - 1, I(s[1]) - 1, D(s[2])));
		}
		int start = I(in.nextLine());
		// System.out.println("DIST: " + Arrays.toString(BellmanFord(g,
		// start)));
		// Object[] ans = BF(g, start);
		// System.out.println("DIST [BF]: " + Arrays.toString((Double[])
		// ans[0]));
		// System.out.println("PRNT [BF]: " + Arrays.toString((Integer[])
		// ans[1]));
		Object[] ans = DK(g, start);
		System.out.println("DIST [DK]: " + Arrays.toString((Double[]) ans[0]));
		// System.out.println("PRNT [DK]: " + Arrays.toString((Integer[])
		// ans[1]));
		System.out.println("DIST: " + Arrays.toString(Dijkstra(g, start)));
		System.out.println("--------------------------------------------");
		System.out.println("----------------------FW--------------------");
		double[][] fw = FW(g);
		for (int i = 0; i < N; i++)
			System.out.println("SP of [" + i + "]: " + Arrays.toString(fw[i]));
		in.close();
	}
}
