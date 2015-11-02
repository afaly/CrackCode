package ch_09;

import java.util.ArrayList;

public class Q06_1 {

	private static ArrayList<String> lst;
	private static int N;
	private static char OPEN = '(', CLOS = ')';

	public static ArrayList<String> genParenthesis(int n) {
		lst = new ArrayList<String>();
		N = n << 1;
		gen_parenthesis(n, n, 0, new char[N]);
		return lst;
	}

	public static void gen_parenthesis(int o, int c, int i, char[] s) {
		if (o == 0) {
			for (int j = i; j < N; j++)
				s[j] = CLOS;
			lst.add(new String(s));
			return;
		}
		s[i] = OPEN;
		gen_parenthesis(o - 1, c, i + 1, s);
		if (c > o) {
			s[i] = CLOS;
			gen_parenthesis(o, c - 1, i + 1, s);
		}
	}

	public static void main(String[] args) {
		ArrayList<String> res = genParenthesis(3);
		System.out.println(res);
	}

}
