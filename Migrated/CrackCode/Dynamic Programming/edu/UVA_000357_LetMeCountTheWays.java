package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_000357_LetMeCountTheWays {

	private static int[] d;
	private static int N;
	private static long[][] mem;

	public static long[] BU_CntChange(int[] denom, int value) {
		d = denom;
		N = d.length;
		Arrays.sort(d);
		long[][] dp = new long[N + 1][value + 1];
		for (int i = 0; i <= N; i++)
			dp[i][0] = 1;
		for (int v = d[0]; v <= value; v += d[0]) {
			for (int i = 1; i <= N; i++) {
				dp[i][v] = dp[i - 1][v];
				if (v >= d[i - 1]) dp[i][v] += dp[i][v - d[i - 1]];
			}
		}
		return dp[N];
	}

	public static long TD_CntChange(int[] denom, int value) {
		d = denom;
		N = d.length;
		Arrays.sort(d);
		mem = new long[N][value + 1];
		for (long[] t : mem)
			Arrays.fill(t, -1l);
		return cntChange(0, value);
	}

	private static long cntChange(int i, int value) {
		if (i == N || value < d[i]) return value == 0 ? 1 : 0;
		if (mem[i][value] >= 0) return mem[i][value];
		mem[i][value] = 0;
		mem[i][value] += cntChange(i, value - d[i]);
		mem[i][value] += cntChange(i + 1, value);
		return mem[i][value];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] denom = { 1, 5, 10, 25, 50 };
		long[] res = BU_CntChange(denom, 30000);
		String s = in.nextLine().trim();
		while (s != null && !s.isEmpty()) {
			System.out.println(res[I(s)]);
			// System.out.print(TD_CntChange(denom, I(s)));
			s = in.nextLine();
		}
		in.close();
	}
}
