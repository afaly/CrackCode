package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UVA_000624_CD {

	public static ArrayList<Integer> CD(Integer[] m, int C) {
		int N = m.length;
		Arrays.sort(m, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return -a.compareTo(b);
			}
		});
		int[][] dp = new int[N + 1][C + 1];
		boolean[][] dk = new boolean[N + 1][C + 1];
		for (int i = 1; i <= N; i++) {
			for (int c = 1; c <= C; c++) {
				dp[i][c] = dp[i - 1][c];
				dk[i][c] = false;
				if (m[i - 1] <= c && dp[i][c] < dp[i - 1][c - m[i - 1]] + 1) {
					dp[i][c] = dp[i - 1][c - m[i - 1]] + 1;
					dk[i][c] = true;
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = N, c = C; i >= 1; i--)
			if (dk[i][c]) {
				res.add(m[i - 1]);
				c -= m[i - 1];
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
		// int[] res = CD(new Integer[] { 1, 3, 4 }, 5);
		ArrayList<Integer> res = CD(new Integer[] { 10, 23, 2, 3, 4, 5, 7 }, 10);
		System.out.println(res);
		in.close();
	}
}
