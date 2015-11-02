package edu;

import java.util.Arrays;

public class KnapSack {

	private static int[] w, v;
	private static int N;
	private static int[][] mem;

	public static int Knapsack(int[] weight, int[] value, int cap) {
		w = weight;
		v = value;
		N = w.length;
		mem = new int[N + 1][cap + 1];
		return knapsack(0, cap);
	}

	public static int Knapsack_Multi(int[] weight, int[] value, int cap) {
		w = weight;
		v = value;
		N = w.length;
		mem = new int[N + 1][cap + 1];
		return knapsack_multi(0, cap);
	}

	private static int knapsack(int i, int rem) {
		if (rem == 0 || i == N) return 0;
		if (mem[i][rem] > 0) return mem[i][rem];
		mem[i][rem] = knapsack(i + 1, rem);
		if (rem >= w[i]) mem[i][rem] = Math.max(mem[i][rem],
				v[i] + knapsack(i + 1, rem - w[i]));
		return mem[i][rem];
	}

	private static int knapsack_multi(int i, int rem) {
		if (rem == 0 || i == N) return 0;
		if (mem[i][rem] > 0) return mem[i][rem];
		mem[i][rem] = knapsack_multi(i + 1, rem);
		if (rem >= w[i]) mem[i][rem] = Math.max(mem[i][rem], v[i]
				+ knapsack_multi(i, rem - w[i]));
		return mem[i][rem];
	}

	public static int Knapsack_Dp(int[] w, int[] v, int cap) {
		int N = w.length, W = cap;
		int[][] dp = new int[N + 1][W + 1];
		for (int i = 0; i <= N; i++)
			dp[i][0] = 0;
		Arrays.fill(dp[0], 0);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				dp[i][j] = dp[i - 1][j];
				if (w[i - 1] <= j) dp[i][j] = Math.max(dp[i][j], v[i - 1]
						+ dp[i - 1][j - w[i - 1]]);
			}
		}
		return dp[N][W];
	}

	public static int Knapsack_Multi_Dp(int[] w, int[] v, int cap) {
		int N = w.length, W = cap;
		int[][] dp = new int[N + 1][W + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				dp[i][j] = dp[i - 1][j];
				if (w[i - 1] <= j) dp[i][j] = Math.max(dp[i][j], v[i - 1]
						+ dp[i][j - w[i - 1]]);
			}
		}
		return dp[N][W];
	}

	public static void main(String[] args) {
		int[] ww = { 10, 4, 20, 5, 7 };
		int[] vv = { 10, 15, 3, 1, 4 };
		System.out.println(Knapsack(ww, vv, 12));
		System.out.println(Knapsack_Multi(ww, vv, 12));
		System.out.println(Knapsack_Dp(ww, vv, 12));
		System.out.println(Knapsack_Multi_Dp(ww, vv, 12));
	}

}
