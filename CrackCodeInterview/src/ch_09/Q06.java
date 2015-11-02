package ch_09;

import java.util.ArrayList;

public class Q06 {

	private static ArrayList<String> lst;
	private static int N;

	public static ArrayList<String> Parentheses(int n) {
		lst = new ArrayList<String>();
		N = n;
		parentheses(n, n, new char[2 * n], 0);
		return lst;
	}

	public static void parentheses(int o, int c, char[] v, int i) {
		if (i == 2 * N) lst.add(new String(v));
		if (i < 2 * N && o > 0) {
			v[i] = '(';
			parentheses(o - 1, c, v, i + 1);
		}
		if (i > 0 && c > 0 && o < c) {
			v[i] = ')';
			parentheses(o, c - 1, v, i + 1);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		ArrayList<String> list = Parentheses(n);
		System.out.println(list.size());
		for (String s : list)
			System.out.println(s);
	}

}
