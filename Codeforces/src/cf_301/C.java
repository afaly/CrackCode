package cf_301;

import java.util.Scanner;

public class C {

	public static int Int(String s) {
		return Integer.parseInt(s);
	}

	public static int[] dx = { 0, 0, -1 }, dy = { 1, -1, 0 };
	public static char[][] m;
	public static int N, M, r1, c1, r2, c2;
	public static final char I = '.', C = 'X', V = '#', T = 'T';

	public static boolean valid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static boolean moved = false;

	public static boolean solve(int i, int j) {
		System.out.println("(" + i + "," + j + ")");
		if (!valid(i, j)) return false;
		if (i == r2 && j == c2 && (m[i][j] == C || m[i][j] == T) && moved) return true;
		if (m[i][j] == I || !moved) {
			System.out.println("HERE I");
			m[i][j] = T;
			moved = true;
			boolean res = false;
			for (int k = 0; k < dx.length; k++)
				if (valid(i + dx[k], j + dy[k])) res |= solve(i + dx[k], j
						+ dy[k]);
			m[i][j] = I;
			return res;
		} else if (m[i][j] == T) {
			System.out.println("HERE T");
			m[i][j] = C;
			moved = true;
			boolean res = false;
			for (int k = 0; k < dx.length; k++)
				if (valid(i + dx[k], j + dy[k])) res |= solve(i + dx[k], j
						+ dy[k]);
			m[i][j] = T;
			return res;
		} else if (m[i][j] == C) {
			System.out.println("HERE C");
			m[i][j] = V;
			moved = true;
			boolean res = solve(i + 1, j);
			m[i][j] = C;
			return res;
		} else
			return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");

		N = Int(s[0]);
		M = Int(s[1]);
		m = new char[N][M];
		for (int i = 0; i < N; i++)
			m[i] = in.nextLine().toCharArray();

		s = in.nextLine().split("\\s+");
		r1 = Int(s[0]) - 1;
		c1 = Int(s[1]) - 1;
		s = in.nextLine().split("\\s+");
		r2 = Int(s[0]) - 1;
		c2 = Int(s[1]) - 1;
		moved = false;
		boolean result = solve(r1, c1);
		if (result) System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}

}
