package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_010261_Ferries {

	private static int[] f;
	private static int N;
	private static int[][][] mem;

	public static int ferries(int[] cars, int C) {
		f = cars;
		N = cars.length;
		mem = new int[N][C + 1][C + 1];
		for (int[][] a : mem)
			for (int[] b : a)
				Arrays.fill(b, -1);
		return ferries(0, C, C);
	}

	private static int ferries(int i, int cl, int cr) {
		if (i == N || (cl < f[i] && cr < f[i])) return 0;
		if (mem[i][cl][cr] >= 0) return mem[i][cl][cr];
		mem[i][cl][cr] = 0;
		if (cl >= f[i]) mem[i][cl][cr] = Math.max(mem[i][cl][cr],
				ferries(i + 1, cl - f[i], cr) + 1);
		if (cr >= f[i]) mem[i][cl][cr] = Math.max(mem[i][cl][cr],
				ferries(i + 1, cl, cr - f[i]) + 1);
		return mem[i][cl][cr];
	}

	public static int[] Ferries(int[] f, int C) {
		N = ferries(f, C);
		int[][] dp = new int[N + 1][C + 1];
		boolean[][] pt = new boolean[N + 1][C + 1];

		for (int i = 1; i <= N; i++) {
			for (int c = 1; c <= C; c++) {
				dp[i][c] = dp[i - 1][c];
				if (c >= f[i - 1] && dp[i][c] < dp[i - 1][c - f[i - 1]] + 1) {
					dp[i][c] = dp[i - 1][c - f[i - 1]] + 1;
					pt[i][c] = true;
				}
			}
		}
		System.out.println("MAX: " + dp[N][C]);
		int[] res = new int[N];
		for (int i = N, c = C; i >= 1; i--) {
			if (pt[i][c]) {
				c -= f[i - 1];
				res[i - 1] = 1;
			}
		}
		for (int i = 0, c = C; i < N; i++) {
			if (res[i] == 0) {
				if (c < f[i]) break;
				c -= f[i];
				res[i] = 2;
			}
		}
		return res;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 50
		// 2500
		// 3000
		// 1000
		// 1000
		// 1500
		// 700
		// 800
		int[] f = { 25, 30, 10, 10, 15, 7, 8, 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(Ferries(f, 50)));
		in.close();
	}

}
