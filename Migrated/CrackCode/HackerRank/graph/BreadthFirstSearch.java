package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class e implements Comparable<e> {
		int n;
		double w;

		public e(int node, double weight) {
			this.n = node;
			this.w = weight;
		}

		@Override
		public int compareTo(e that) {
			return new Double(this.w).compareTo(that.w);
		}
	}

	static class adj {
		ArrayList<e> lst;

		public adj() {
			lst = new ArrayList<e>();
		}

		public void add(e edge) {
			lst.add(edge);
		}

		public void add(int node, double weight) {
			lst.add(new e(node, weight));
		}

		public int size() {
			return lst.size();
		}

	}

	static class T {
		int n, d, p;

		public T(int node, int dist, int prnt) {
			this.n = node;
			this.d = dist;
			this.p = prnt;
		}
	}

	public static int[] bfsm(boolean[][] g, int N, int S) {
		int[] dist = new int[N];
		int D = 0;
		Arrays.fill(dist, -1);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		while (!q.isEmpty()) {
			for (int sz = q.size(); sz > 0; sz--) {
				int src = q.poll();
				if (dist[src] == -1) {
					dist[src] = D;
					for (int i = 0; i < N; i++) {
						if (g[src][i] && dist[i] == -1) {
							g[src][i] = false;
							g[i][src] = false;
							q.add(i);
						}
					}
				}
			}
			D += 6;
		}
		return dist;
	}

	public static int[] bfs(boolean[][] g, int N, int S) {
		int[] dist = new int[N];
		int[] prnt = new int[N];
		Arrays.fill(dist, -1);
		Arrays.fill(prnt, -1);

		Queue<T> q = new LinkedList<T>();
		q.add(new T(S, 0, -1));
		while (!q.isEmpty()) {
			T src = q.poll();
			if (dist[src.n] == -1) {
				dist[src.n] = src.d;
				prnt[src.n] = src.p;
				for (int i = 0; i < N; i++) {
					if (g[src.n][i] && dist[i] == -1) {
						g[src.n][i] = false;
						g[i][src.n] = false;
						q.add(new T(i, src.d + 6, src.n));
					}
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine()), N, M, S;
		String[] s;
		boolean[][] adj;
		while (T-- > 0) {
			s = in.nextLine().split("\\s+");
			N = I(s[0]);
			M = I(s[1]);
			adj = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				s = in.nextLine().split("\\s+");
				int src = I(s[0]) - 1, dst = I(s[1]) - 1;
				adj[src][dst] = true;
				adj[dst][src] = true;
			}
			S = I(in.nextLine()) - 1;
			int[] dist = bfsm(adj, N, S);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++)
				if (i != S) sb.append(dist[i]).append(" ");
			System.out.println(sb.toString().trim());
		}

		in.close();
	}
}
