package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_000147_Dollars {

	private static int[] c;
	private static int N, V;

	public static long[] CntChange(int[] coins) {
		c = coins;
		N = coins.length;
		V = 6000;
		Arrays.sort(c);
		long[][] dp = new long[N + 1][V + 1];
		for (int i = 1; i <= N; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int v = c[0]; v <= V; v += c[0]) {
				dp[i][v] = dp[i - 1][v];
				if (c[i - 1] <= v) dp[i][v] += dp[i][v - c[i - 1]];
			}
		}
		return dp[N];
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
		int[] coins = { 1, 2, 4, 10, 20, 40, 100, 200, 400, 1000, 2000 };
		long[] res = CntChange(coins);
		double val = in.nextDouble();
		while (val > 0) {
			val *= 20;
			System.out.println(res[(int) val]);
			val = in.nextDouble();
		}
		in.close();
	}
}
