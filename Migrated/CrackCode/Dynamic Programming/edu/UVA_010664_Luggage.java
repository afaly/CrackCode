package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_010664_Luggage {

	private static int[] w;
	private static int N, S;
	private static Boolean[][] mem;

	public static boolean BU_Luggage(int[] weights) {
		w = weights;
		N = weights.length;
		S = 0;
		for (int x : weights)
			S += x;
		if ((S & 1) == 1) return false;
		boolean[][] dp = new boolean[N + 1][(S >> 1) + 1];
		for (int i = 0; i <= N; i++)
			dp[i][0] = true;
		for (int i = 1; i <= N; i++) {
			for (int c = 1; c <= S >> 1; c++) {
				dp[i][c] |= dp[i - 1][c];
				if (c >= w[i - 1]) dp[i][c] |= dp[i - 1][c - w[i - 1]];
			}
		}
		return dp[N][S >> 1];
	}

	public static boolean TD_Luggage(int[] weights) {
		w = weights;
		N = weights.length;
		S = 0;
		for (int x : weights)
			S += x;
		mem = new Boolean[N][201];
		for (Boolean[] t : mem)
			Arrays.fill(t, null);
		return (S & 1) == 0 ? luggage(0, S >> 1) : false;
	}

	private static boolean luggage(int i, int s) {
		if (i == N) return s == 0;
		if (mem[i][s] != null) return mem[i][s];
		mem[i][s] = false;
		mem[i][s] |= luggage(i + 1, s);
		if (s >= w[i]) mem[i][s] |= luggage(i + 1, s - w[i]);
		return mem[i][s];
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
			String s = in.nextLine();
			System.out.println(TD_Luggage(IA(s)) ? "YES" : "NO");
			System.out.println(BU_Luggage(IA(s)) ? "YES" : "NO");
		}

		in.close();
	}
}
