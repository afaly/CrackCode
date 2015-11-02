package ch_10;

import java.util.Arrays;

public class Q02 {

	public static int[] freq(String s) {
		int[] f = new int[26];
		for (int i = 0; i < s.length(); i++)
			f[s.charAt(i) - 'a']++;
		return f;
	}

	static class P implements Comparable<P> {
		int[] f;
		String s;

		public P(String str) {
			this.s = str;
			this.f = freq(str);
		}

		@Override
		public int compareTo(P that) {
			int cmp = 0;
			for (int i = 0; i < 26; i++) {
				cmp = this.f[i] - that.f[i];
				if (cmp > 0) return -1;
				else if (cmp < 0) return 1;
			}
			return 0;
		}

	}

	public static String[] sortAnagrams(String[] s) {
		P[] p = new P[s.length];
		for (int i = 0; i < s.length; i++)
			p[i] = new P(s[i]);
		Arrays.sort(p);
		for (int i = 0; i < s.length; i++)
			s[i] = p[i].s;
		return s;
	}

	public static void main(String[] args) {
		String[] s = { "zyx", "abab", "aacc", "baab", "caca", "xyz", "abba" };
		s = sortAnagrams(s);
		System.out.println(Arrays.toString(s));
	}

}
