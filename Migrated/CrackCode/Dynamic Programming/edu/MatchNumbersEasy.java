package edu;

import java.util.Arrays;

public class MatchNumbersEasy {

	private static int[] V;
	private static int MIN;

	public static String maxNumber(int[] matches, int n) {
		V = new int[51];
		Arrays.fill(V, -1);
		MIN = 51;
		for (int i = 0; i < matches.length; i++) {
			V[matches[i]] = i;
			MIN = Math.min(MIN, matches[i]);
		}
		String res = maxNumber(n, 0, "");
		return res.isEmpty() ? "0" : res;
	}

	public static String max(String a, String b) {
		int lena = a.length(), lenb = b.length();
		if (lena > lenb) return a;
		else if (lenb > lena) return b;
		else return a.compareTo(b) > 0 ? a : b;
	}

	private static String maxNumber(int v, int i, String s) {
		if (v < MIN) return s;
		String S = "";
		for (int j = v; j >= 1; j--) {
			if (((V[j] >= 0 && i > 0) || (V[j] > 0 && i == 0)) && V[j] <= 9) {
				S = max(S, maxNumber(v - j, i + 1, s + V[j]));
			}
		}
		return S;
	}

	public static void main(String[] args) {
		System.out.println(maxNumber(new int[] { 6, 7, 8 }, 21)); // 210
		System.out.println(maxNumber(new int[] { 5, 23, 24 }, 30)); // 20
		System.out.println(maxNumber(new int[] { 1, 5, 3, 2 }, 1));
		System.out.println(maxNumber(
				new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 50));
	}

}
