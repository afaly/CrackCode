package edu;

import java.util.Arrays;

public class LISS {

	private static int N;
	private static int[] n;
	private static int[][] mem;

	public static int TD_Liss(int[] a) {
		N = a.length;
		n = Arrays.copyOf(a, N + 1);
		n[N] = Integer.MIN_VALUE;
		mem = new int[N + 1][N];
		return liss(N, 0);
	}

	private static int liss(int p, int c) {
		if (c == N) return 0;
		if (mem[p][c] > 0) return mem[p][c];
		mem[p][c] = liss(p, c + 1);
		if (n[p] <= n[c]) mem[p][c] = Math.max(mem[p][c], 1 + liss(c, c + 1));
		return mem[p][c];
	}

	public static int BU_Liss(int[] a) {
		N = a.length;
		n = a;
		int[] dp = new int[N];
		int[] pd = new int[N];
		Arrays.fill(dp, 1);
		Arrays.fill(pd, -1);
		for (int i = 1; i < N; i++)
			for (int j = i - 1; j >= 0; j--)
				if (a[i] > a[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					pd[i] = j;
				}
		int idx = 0, itr;
		for (int i = N - 1; i >= 0; i--)
			if (dp[i] > dp[idx]) idx = i;
		itr = idx;
		while (itr >= 0) {
			System.out.print(a[itr] + " ");
			itr = pd[itr];
		}
		System.out.println();
		return dp[idx];
	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 2, 3, 1, 2, 4, 5 };
		System.out.println(TD_Liss(a));
		System.out.println(BU_Liss(a));
	}
}
