package edu;

import java.util.Arrays;

public class KSack {

	private static int N;
	private static int[] w, v;
	private static long[][] mem;

	public static long TD_Knapsack(int[] weight, int[] value, int C) {
		w = weight;
		v = value;
		N = Math.min(value.length, weight.length);
		mem = new long[N][C + 1];
		for (long[] m : mem)
			Arrays.fill(m, -1);
		return knapsack(0, C);
	}

	private static long knapsack(int i, int c) {
		if (i == N || c == 0) return 0l;
		if (mem[i][c] >= 0) return mem[i][c];
		mem[i][c] = knapsack(i + 1, c);
		if (w[i] <= c) mem[i][c] = Math.max(mem[i][c],
				v[i] + knapsack(i + 1, c - w[i]));
		return mem[i][c];
	}

	public static long TD_Knapsack_Multi(int[] weight, int[] value, int C) {
		w = weight;
		v = value;
		N = Math.min(value.length, weight.length);
		mem = new long[N][C + 1];
		for (long[] m : mem)
			Arrays.fill(m, -1);
		return knapsack_multi(0, C);
	}

	private static long knapsack_multi(int i, int c) {
		if (i == N || c == 0) return 0l;
		if (mem[i][c] >= 0) return mem[i][c];
		mem[i][c] = knapsack_multi(i + 1, c);
		if (w[i] <= c) mem[i][c] = Math.max(mem[i][c],
				v[i] + knapsack_multi(i, c - w[i]));
		return mem[i][c];
	}

	public static long BU_Knapsack(int[] weight, int[] value, int C) {
		w = weight;
		v = value;
		N = Math.min(value.length, weight.length);
		mem = new long[N + 1][C + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= C; j++) {
				mem[i][j] = mem[i - 1][j];
				if (w[i - 1] <= j) mem[i][j] = Math.max(mem[i][j], mem[i - 1][j
						- w[i - 1]]
						+ v[i - 1]);
			}
		}
		return mem[N][C];
	}

	public static long BU_Knapsack_Multi(int[] weight, int[] value, int C) {
		w = weight;
		v = value;
		N = Math.min(value.length, weight.length);
		mem = new long[N + 1][C + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= C; j++) {
				mem[i][j] = mem[i - 1][j];
				if (w[i - 1] <= j) mem[i][j] = Math.max(mem[i][j], mem[i][j
						- w[i - 1]]
						+ v[i - 1]);
			}
		}
		return mem[N][C];
	}

	public static void main(String[] args) {
		int[] ww = { 10, 4, 20, 5, 7 };
		int[] vv = { 10, 15, 3, 1, 4 };
		System.out.println(TD_Knapsack(ww, vv, 20));
		System.out.println(TD_Knapsack_Multi(ww, vv, 20));
		System.out.println(BU_Knapsack(ww, vv, 20));
		System.out.println(BU_Knapsack_Multi(ww, vv, 20));
	}

}
