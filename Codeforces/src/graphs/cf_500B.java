package graphs;

import java.util.Arrays;
import java.util.Scanner;

public class cf_500B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class Pair implements Comparable<Pair> {
		int i, v;

		public Pair(int i, int v) {
			this.i = i;
			this.v = v;
		}

		@Override
		public int compareTo(Pair o) {
			return v - o.v;
		}

		@Override
		public String toString() {
			return "Pair [i=" + i + ", v=" + v + "]";
		}
	}

	private static Pair[] n;
	private static char[][] a;
	private static boolean[][] v;
	private static int N;

	public static boolean path(int i, int j) {
		if (a[i][j] == '1') return true;
		if (v[i][j]) return false;
		v[i][j] = true;
		for (int k = 0; k < N; k++) {
			if (a[i][k] == '1' && !v[i][k]) {
				if (path(k, j)) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		in.nextLine();
		String[] s = in.nextLine().split("\\s+");
		n = new Pair[N];
		a = new char[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			n[i] = new Pair(i, I(s[i]));
			a[i] = in.nextLine().toCharArray();
		}
		Arrays.sort(n);
		// System.out.println(Arrays.toString(n));
		for (int k = 0; k < N; k++) {
			int j = n[k].i, i = k;
			while (i < N && n[k].v <= n[i].v && !path(i, j)) {
				// System.out.println(i + "," + j + "   : " + n[i].v);
				i++;
			}
			if (i < N && n[k].v <= n[i].v) System.out.println(n[k].v + " : "
					+ i);
		}

		in.close();
	}
}
