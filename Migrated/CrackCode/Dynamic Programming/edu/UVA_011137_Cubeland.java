package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_011137_Cubeland {

	private static int[] c;
	private static int N;
	private static long[][] mem;

	public static long[] BU_CntChange(int[] change, int val) {
		c = change;
		N = change.length;
		long[][] dp = new long[N + 1][val + 1];
		Arrays.sort(c);
		for (int i = 1; i <= N; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int v = c[0]; v <= val; v += c[0]) {
				dp[i][v] = dp[i - 1][v];
				if (v >= c[i - 1]) dp[i][v] += dp[i][v - c[i - 1]];
			}
		}
		return dp[N];
	}

	public static long TD_CntChange(int[] change, int val) {
		c = change;
		N = change.length;
		mem = new long[N][val + 1];
		for (long[] t : mem)
			Arrays.fill(t, -1l);
		Arrays.sort(c);
		return cntChange(0, val);
	}

	private static long cntChange(int i, int val) {
		if (i == N || val < c[i]) return val == 0 ? 1 : 0;
		if (mem[i][val] >= 0) return mem[i][val];
		return mem[i][val] = cntChange(i + 1, val) + cntChange(i, val - c[i]);
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
		int[] change = new int[21];
		for (int i = 0; i < 21; i++)
			change[i] = (int) Math.pow((i + 1), 3);
		long[] res = BU_CntChange(change, 10000);
		String s = in.nextLine();
		while (s != null && !s.isEmpty()) {
			int val = I(s);
			System.out.println(res[val]);
			s = in.nextLine();
		}
		in.close();
	}
}
