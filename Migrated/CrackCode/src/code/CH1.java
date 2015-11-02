package code;

import java.util.Arrays;

public class CH1 {

	static boolean isStrPermute(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		char[] c1 = s1.toLowerCase().toCharArray();
		char[] c2 = s2.toLowerCase().toCharArray();
		int[] freq = new int[256];
		for (int i : c1)
			freq[i]++;
		for (int i : c2)
			freq[i]--;
		for (int i : freq)
			if (freq[i] != 0) return false;
		return true;
	}

	static String strModifySpaces(String s, String r) {
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char cc : c) {
			if (cc == ' ') sb.append(r);
			else sb.append(cc);
		}
		return sb.toString();
	}

	static String strCompress(String s) {
		if (s == null || s.length() <= 1) return s;
		StringBuilder sb = new StringBuilder();
		char[] c = s.toCharArray();
		char p = c[0];
		int cnt = 0;
		for (char cc : c) {
			if (cc == p) cnt++;
			else {
				sb.append(p).append(cnt);
				p = cc;
				cnt = 1;
			}
		}
		String ss = sb.append(p).append(cnt).toString();
		return ss.length() < s.length() ? ss : s;
	}

	static int[][] replaceZero(int[][] n) {
		int I = n.length;
		int J = n[0].length;
		boolean[] rows = new boolean[I];
		boolean[] cols = new boolean[J];
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if (n[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if (rows[i] || cols[j]) n[i][j] = 0;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(isStrPermute("C OO  L", "l   oco"));
		System.out.println(strModifySpaces("Hi Abdalrhman Fathy", "%20"));
		System.out.println(strCompress("abbbbbbbbcdddaaaabbc"));
		int[][] n = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 0, 3 },
				{ 4, 0, 4, 4 } };
		n = replaceZero(n);
		for (int[] a : n)
			System.out.println(Arrays.toString(a));
	}

}
