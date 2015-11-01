package cf_311;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
	static class p implements Comparable<p> {
		int l, d;

		public p(int l, int d) {
			this.l = l;
			this.d = d;
		}

		@Override
		public int compareTo(p other) {
			return l = other.l;
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static boolean V(double val, double W) {
		return Math.abs(val - W) < 1e-9;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		p[] v = new p[N];
		int[] e = new int[100001];
		int[] c = new int[100001];
		int[] x = new int[100001];
		String[] sl = in.nextLine().split("\\s+");
		String[] sd = in.nextLine().split("\\s+");
		for (int i = 0; i < N; i++) {
			int l = I(sl[i]), d = I(sd[i]);
			e[l] += d;
			c[l]++;
			v[i] = new p(l, d);
		}
		for (int i = N - 2; i >= 0; i--)
			e[i] += e[i - 1];
		Arrays.sort(v);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int lvl = v[0].l, i = 0;
		while (lvl < v[N].l) {
			while (v[i].l < lvl)
				pq.offer(v[i].l);
			int cost = 0, cnt = 0;
			while (!pq.isEmpty());
		}
		in.close();
	}
}
