package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmicCrush {
	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class P implements Comparable<P> {
		int i, v;

		public P(int idx, int val) {
			this.i = idx;
			this.v = val;
		}

		@Override
		public int compareTo(P that) {
			return this.i - that.i == 0 ? -this.v + that.v : this.i - that.i;
		}

		@Override
		public String toString() {
			return i + "/" + v;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().trim().split("\\s+");
		int N = I(s[0]), M = I(s[1]);
		P[] n = new P[2 * M];
		for (int i = 0, j = 0; i < M && j < 2 * M; i++) {
			s = in.nextLine().trim().split("\\s+");
			n[j++] = new P(I(s[0]) - 1, I(s[2]));
			n[j++] = new P(I(s[1]), -I(s[2]));
		}
		Arrays.sort(n);
		// System.out.println(Arrays.toString(n));
		int cur = 0, max = Integer.MIN_VALUE, j = n[0].i;
		for (int i = 0; i < 2 * M; i++) {
			if (j != n[i].i) {
				j = n[i].i;
				max = Math.max(max, cur);
			}
			cur += n[i].v;
		}
		System.out.println(max);
		in.close();
	}
}
