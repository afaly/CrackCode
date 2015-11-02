package edu;

public class LongestCommonSubsequence {

	private static char[] a, b;
	private static int[][] mem;

	public static int LCS(String sa, String sb) {
		a = sa.toCharArray();
		b = sb.toCharArray();
		mem = new int[a.length][b.length];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b.length; j++)
				mem[i][j] = -1;
		return lcs(0, 0);
	}

	private static int lcs(int i, int j) {
		if (i >= a.length || j >= b.length) return 0;
		if (mem[i][j] >= 0) return mem[i][j];
		if (a[i] == b[j]) mem[i][j] = 1 + lcs(i + 1, j + 1);
		else
			mem[i][j] = Math.max(lcs(i + 1, j), lcs(i, j + 1));
		return mem[i][j];
	}

	public static int LCS_DP(String sa, String sb) {
		a = sa.toCharArray();
		b = sb.toCharArray();
		mem = new int[a.length + 1][b.length + 1];

		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1]) mem[i][j] = 1 + mem[i - 1][j - 1];
				else
					mem[i][j] = Math.max(mem[i][j - 1], mem[i - 1][j]);
			}
		}
		return mem[a.length][b.length];
	}

	public static void main(String[] args) {
		String A = "abcduuerietfg";
		String B = "abcdefgabcduuerietfg";
		System.out.println(LCS(A, B));
		System.out.println(LCS_DP(A, B));
	}

}
