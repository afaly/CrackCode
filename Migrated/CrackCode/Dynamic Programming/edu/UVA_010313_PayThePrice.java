package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_010313_PayThePrice {

	private static int A = 301;
	private static long[][] dp;

	public static long PayThePrice() {

		dp = new long[A][A];
		Arrays.fill(dp[0], 1);
		for (int v = 0; v < A; v++) {
			for (int c = 1; c < A; c++) {
				dp[v][c] = dp[v][c - 1] + (v >= c ? dp[v - c][c] : 0);
			}
		}

		System.out.println(Arrays.toString(dp[6]));
		return 0;
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
		PayThePrice();
		in.close();
	}
}
