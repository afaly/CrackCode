package edu;

import java.util.Scanner;

public class UVA_010130_Supersale {

	private static int[] w, p;
	private static int N, MC;

	public static long Supersale(int[] weight, int[] profit, int[] capacities) {
		w = weight;
		N = weight.length;
		p = profit;
		MC = 30;
		long[][] dp = new long[N + 1][MC + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= MC; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= w[i - 1]
						&& dp[i][j] < dp[i - 1][j - w[i - 1]] + p[i - 1]) dp[i][j] = dp[i - 1][j
						- w[i - 1]]
						+ p[i - 1];
			}
		}

		long max = 0;
		for (int c : capacities)
			max += dp[N][c];
		return max;
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
		int T = I(in.nextLine());
		while (T-- > 0) {
			int N = I(in.nextLine());
			int[] weight = new int[N];
			int[] profit = new int[N];
			while (--N >= 0) {
				int[] v = IA(in.nextLine());
				profit[N] = v[0];
				weight[N] = v[1];
			}

			int G = I(in.nextLine());
			int[] capacities = new int[G];
			while (--G >= 0) {
				capacities[G] = I(in.nextLine());
			}

			System.out.println(Supersale(weight, profit, capacities));
		}
		in.close();
	}
}
