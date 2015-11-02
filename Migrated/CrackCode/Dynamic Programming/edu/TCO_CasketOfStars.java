package edu;

import java.util.Arrays;

public class TCO_CasketOfStars {

	private static int[] s;
	private static int N;
	private static long[][] mem;

	public static long TD_CasketOfStars(int[] stars) {
		s = stars;
		N = stars.length;
		mem = new long[N][N];
		for (long[] t : mem)
			Arrays.fill(t, -1l);
		return casketOfStars(0, N - 1);
	}

	private static long casketOfStars(int i, int j) {
		if (j - i <= 1) return 0;
		if (mem[i][j] >= 0) return mem[i][j];
		if (j - i == 2) return mem[i][j] = s[i] * s[j];
		for (int k = i + 1; k < j; k++) {
			mem[i][j] = Math.max(mem[i][j], casketOfStars(i, k)
					+ casketOfStars(k, j) + s[i] * s[j]);
		}
		return mem[i][j];
	}

	public static void main(String[] args) {
		int[] stars = { 1, 2, 3, 4 };
		System.out.println(TD_CasketOfStars(stars));
	}

}
