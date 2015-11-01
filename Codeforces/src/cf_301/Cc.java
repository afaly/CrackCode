package cf_301;

import java.util.Scanner;

public class Cc {

	public static int Int(String s) {
		return Integer.parseInt(s);
	}

	public static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	public static char[][] m;
	public static int N, M, r1, c1, r2, c2;
	public static final char I = '.', C = 'X', V = '#';

	public static boolean valid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static boolean moved = false;

	public static boolean Solve() {
		boolean neig = false;
		int neigI = 0;
		for (int k = 0; k < dx.length; k++) {
			neig |= r1 + dx[k] == r2 && c1 + dy[k] == c2;
			if (valid(r2 + dx[k], c2 + dy[k])) neigI = m[r2 + dx[k]][c2 + dy[k]] == I ? neigI + 1
					: neigI;
		}
		if (r1 == r2 && c1 == c2) return neigI > 0;
		else if (neig) return m[r2][c2] == C || neigI > 0;
		else {
			boolean isC = m[r2][c2] == C;
			return solve(r1, c1) && (isC || neigI > 0);
		}
	}

	private static boolean solve(int i, int j) {
		if (!valid(i, j)) return false;
		if (i == r2 && j == c2) return true;
		if (m[i][j] == I) {
			m[i][j] = C;
			boolean res = false;
			for (int k = 0; k < dx.length - 1; k++)
				if (valid(i + dx[k], j + dy[k])) res |= solve(i + dx[k], j
						+ dy[k]);
			m[i][j] = I;
			return res;
		} else if (m[i][j] == C) {
			m[i][j] = V;
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
		boolean result = Solve();
		if (result) System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}

}
