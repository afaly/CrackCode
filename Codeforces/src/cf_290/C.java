package cf_290;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class C {

	private static int i(char c) {
		return c - 'a';
	}

	private static boolean[][] m;
	private static boolean[] f;
	private static Stack<Integer> stack;
	private static int L = 26;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		char[][] c = new char[n][];
		for (int i = 0; i < n; i++) {
			c[i] = in.nextLine().toCharArray();
		}

		m = new boolean[L][L];
		boolean sol = true;
		for (int i = 0; i < n - 1 && sol; i++) {
			int k = i + 1;
			boolean tie = true;
			for (int j = 0; j < Math.min(c[i].length, c[k].length) && tie
					&& sol; j++) {
				int v1 = i(c[i][j]);
				int v2 = i(c[k][j]);
				if (v1 == v2)
					continue;
				m[v1][v2] = true;
				if (m[v2][v1])
					sol = false;
				tie = (v1 == v2);
			}
		}

		if (sol) {
			int[] cnt = new int[L];
			for (int k = 0; k < L; k++) {
				for (int i = 0; i < L; i++) {
					for (int j = 0; j < L; j++) {
						m[i][j] |= m[i][k] && m[k][j];
					}
				}
			}

			for (int i = 0; i < L; i++)
				for (int j = 0; j < L; j++)
					if (m[i][j])
						cnt[j]++;
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < L; i++) {
				if (cnt[i] == 0)
					q.add(i);
			}
			while (!q.isEmpty()) {
				int at = q.poll();
				System.out.print((char) ('a' + at));
				for (int i = 0; i < L; i++) {
					if (m[i][at]) {
						cnt[i]--;
						if (cnt[i] == 0)
							q.add(i);
					}
				}
			}
			System.out.println("---------");
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					if (m[i][j]) {
						System.out.println((char) (i + 'a') + " > "
								+ (char) (j + 'a'));
					}
				}
			}
			stack = new Stack<Integer>();
			f = new boolean[26];
			for (int i = 0; i < f.length; i++) {
				if (!f[i]) {
					visit(i);
				}
			}

			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append((char) (stack.pop() + 'a'));
			}
			System.out.println(sb.reverse().toString());
		}
		in.close();
	}

	private static void visit(int i) {
		f[i] = true;
		for (int j = 0; j < f.length; j++) {
			if (m[i][j] && !f[j]) {
				visit(j);
			}
		}
		stack.push(i);
	}
	// abcdefghijklmnopqrstuvwxyz
	// aghjlnopefikdmbcqrstuvwxyz
	// apefikdmbcghjlnoqrstuvwxyz
}
