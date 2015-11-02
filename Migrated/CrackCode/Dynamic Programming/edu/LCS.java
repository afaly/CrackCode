package edu;

import java.util.Arrays;

public class LCS {

	private static char[] a, b;
	private static int Na, Nb;
	private static long[][] mem;

	public static long TD_LCS(String aStr, String bStr) {
		a = aStr.toCharArray();
		b = bStr.toCharArray();
		Na = a.length;
		Nb = b.length;
		mem = new long[Na][Nb];
		for (long[] t : mem)
			Arrays.fill(t, -1l);
		return lcs(0, 0);
	}

	private static long lcs(int i, int j) {
		if (i == Na || j == Nb) return 0;
		if (mem[i][j] >= 0) {
			System.out.println("Mem -> " + i + ", " + j + " : " + mem[i][j]);
			return mem[i][j];
		}
		if (a[i] == b[j]) return mem[i][j] = 1 + lcs(i + 1, j + 1);
		return mem[i][j] = Math.max(lcs(i + 1, j), lcs(i, j + 1));
	}

	public static long BU_LCS(String aStr, String bStr) {
		a = aStr.toCharArray();
		b = bStr.toCharArray();
		Na = a.length;
		Nb = b.length;
		mem = new long[Na + 1][Nb + 1];
		for (int i = 1; i <= Na; i++) {
			for (int j = 1; j <= Nb; j++) {
				if (a[i - 1] == b[j - 1]) mem[i][j] = mem[i - 1][j - 1] + 1;
				else mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
			}
		}
		return mem[Na][Nb];
	}

	public static void main(String[] args) {
		String a = "abcxyz";
		String b = "xklmnymnabz";
		System.out.println("TD LCS : " + TD_LCS(a, b));
		System.out.println("BU LCS : " + BU_LCS(a, b));
	}
}
