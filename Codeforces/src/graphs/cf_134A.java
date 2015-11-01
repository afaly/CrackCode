package graphs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class cf_134A {

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

	static class Pair {
		int i, j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return i + " " + j;
		}
	}

	public static boolean valid(int i, int j) {
		return i >= 0 && i <= 1000 && j >= 0 && j <= 1000;
	}

	public static final int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = I(in.nextLine()), i = 0, j = 0;
		// int[][] m = new int[1001][1001];
		// ArrayList<Pair> l = new ArrayList<Pair>(M);
		int[] r = new int[M];
		int[] c = new int[M];
		Set<Integer> sr = new HashSet<Integer>(), sc = new HashSet<Integer>();
		String[] s;
		for (int k = 0; k < M; k++) {
			s = in.nextLine().split("\\s+");
			i = I(s[0]);
			j = I(s[1]);
			r[k] = i;
			c[k] = j;
			sr.add(i);
			sc.add(j);
			// m[i][j] = 1;
			// l.add(new Pair(i, j));
		}

		int ans = 0;
		for (Integer ii : sr) {
			boolean found = false;
			for (int k = 0; k < M && !found; k++) {
				if (r[k] == ii) {
					if (sc.contains(c[k])) {
						found = true;
					}
				}
			}
		}

		System.out.println(ans);
		/*-
		Queue<Pair> q = new LinkedList<Pair>();
		int MARK = 1;
		for (Pair pair : l) {
			if (m[pair.i][pair.j] == 1) {
				q.add(pair);
				MARK++;
				while (!q.isEmpty()) {
					Pair t = q.poll();
					if (m[t.i][t.j] == 1) {
						m[t.i][t.j] = MARK;
						for (int k = 0; k < dx.length; k++) {
							ii = t.i + dx[k];
							jj = t.j + dy[k];
							if (valid(ii, jj) && m[ii][jj] == 1) q
									.add(new Pair(ii, jj));
						}
					}
				}
			}
		}
		System.out.println(MARK - 1);
		 */

		in.close();
	}
}
