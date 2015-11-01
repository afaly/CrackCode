package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cf_250C {

	static class adj {
		ArrayList<Integer> l;

		public adj() {
			l = new ArrayList<Integer>();
		}

		public void add(int v) {
			l.add(v);
		}

		public Integer get(int i) {
			if (i >= 0 && i < l.size()) return l.get(i);
			else
				return null;
		}

		public int size() {
			return l.size();
		}
	}

	static class Pair implements Comparable<Pair> {
		int idx, val;

		public Pair(int i, int j) {
			this.idx = i;
			this.val = j;
		}

		@Override
		public String toString() {
			return idx + " " + val;
		}

		@Override
		public int compareTo(Pair arg0) {
			return val - arg0.val;
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class UF {
		int[] n, r;
		int N, C;

		public UF(int size) {
			this.N = size;
			this.C = size;
			this.n = new int[N];
			this.r = new int[N];
			for (int i = 0; i < N; i++)
				n[i] = i;
		}

		public int find(int x) {
			if (n[x] == x) return x;
			n[x] = find(n[x]);
			return n[x];
		}

		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}

		public void union(int x, int y) {
			int px = find(x);
			int py = find(y);
			if (px != py) {
				if (r[px] > r[py]) n[py] = px;
				else if (r[px] < r[py]) n[px] = py;
				else {
					n[px] = py;
					r[px]++;
				}
				C--;
			}
		}

		public int components() {
			return C;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), M = I(s[1]);
		s = in.nextLine().split("\\s+");
		int[] v = new int[N];
		for (int i = 0; i < N; i++)
			v[i] = I(s[i]);
		boolean[][] f = new boolean[N][N];
		int[] q = new int[N];
		int[] c = new int[N];
		for (int i = 0; i < M; i++) {
			s = in.nextLine().split("\\s+");
			int a = I(s[0]) - 1, b = I(s[1]) - 1;
			f[a][b] = true;
			f[b][a] = true;
			q[a] += v[b];
			q[b] += v[a];
			q[a] -= v[a];
			q[b] -= v[b];
			c[a] += v[b];
			c[b] += v[a];
		}

		int minCost = 0;
		boolean[] vis = new boolean[N];
		for (int i = 0; i < N; i++) {
			int minIdx = 0;
			for (int j = 0; j < N; j++) {
				if (vis[minIdx] || (q[minIdx] > q[j] && !vis[j])) minIdx = j;
			}
			System.out.println(Arrays.toString(q));
			System.out.println("DEL : " + (minIdx + 1) + "  : " + q[minIdx]
					+ "  > " + c[minIdx]);
			minCost += c[minIdx];
			for (int j = 0; j < N; j++) {
				if (f[minIdx][j]) {
					q[j] -= v[minIdx];
					c[j] -= v[minIdx];
				}
			}
			vis[minIdx] = true;
		}
		System.out.println(minCost);
		in.close();
	}
}
