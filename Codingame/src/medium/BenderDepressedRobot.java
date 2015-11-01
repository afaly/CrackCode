package medium;

import java.util.ArrayList;
import java.util.Scanner;

public class BenderDepressedRobot {
	private static final String[] DIRECTION = { "SOUTH", "EAST", "NORTH",
			"WEST" };
	private static final int[] DX = { 1, 0, -1, 0 };
	private static final int[] DY = { 0, 1, 0, -1 };

	private static int L, C;

	public static boolean valid(int i, int j) {
		return i >= 0 && i < L && j >= 0 && j < C;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void inc(Point d) {
			this.x += d.x;
			this.y += d.y;
		}

		public void dec(Point d) {
			this.x -= d.x;
			this.y -= d.y;
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		L = in.nextInt();
		C = in.nextInt();
		in.nextLine();
		char[][] M = new char[L][C];
		int[][][] F = new int[L][C][4];
		Point S = null, E = null, T1 = null, T2 = null;
		for (int i = 0; i < L; i++) {
			M[i] = in.nextLine().toCharArray();
			for (int j = 0; j < C
					&& (S == null || E == null || T1 == null || T2 == null); j++) {
				if (M[i][j] == '@') S = new Point(i, j);
				else if (M[i][j] == '$') E = new Point(i, j);
				else if (M[i][j] == 'T' && T1 == null) T1 = new Point(i, j);
				else if (M[i][j] == 'T' && T1 != null) T2 = new Point(i, j);
			}
		}

		boolean finish = false, breaker = false, invert = false;
		int i = S.x, j = S.y, p = 0, limit = 0;
		ArrayList<String> path = new ArrayList<String>();
		while (!finish) {
			if (M[i][j] == '$') {
				finish = true;
				continue;
			} else if (M[i][j] == 'S') p = 0;
			else if (M[i][j] == 'E') p = 1;
			else if (M[i][j] == 'N') p = 2;
			else if (M[i][j] == 'W') p = 3;
			else if (M[i][j] == '#' || (M[i][j] == 'X' && !breaker)) {
				boolean pass = false;
				int k = 0, inc = 1;
				if (invert) {
					k = 3;
					inc = -1;
				}
				// UN-MOVE
				// --------------------------
				i -= DX[p];
				j -= DY[p];
				path.remove(path.size() - 1);
				// --------------------------
				for (; k < 4 && k >= 0 && !pass; k += inc) {
					if (k == p || !valid(i + DX[k], j + DY[k])) continue;
					char nxt = M[i + DX[k]][j + DY[k]];
					if (nxt == '#' || (nxt == 'X' && !breaker)) continue;
					else if (nxt == 'X' && breaker) M[i + DX[k]][j + DY[k]] = ' ';
					p = k;
					pass = true;
				}
			} else if (M[i][j] == 'X' && breaker) {
				M[i][j] = ' ';
				limit++;
			} else if (M[i][j] == 'B') {
				breaker ^= true;
			} else if (M[i][j] == 'I') {
				invert ^= true;
			} else if (M[i][j] == 'T') {
				if (i == T1.x && j == T1.y) {
					i = T2.x;
					j = T2.y;
				} else {
					i = T1.x;
					j = T1.y;
				}
			}
			if (F[i][j][p] == limit + 2) break;
			else F[i][j][p]++;
			i += DX[p];
			j += DY[p];
			path.add(DIRECTION[p]);
		}
		if (finish) {
			for (String ss : path)
				System.out.println(ss);
		} else {
			System.out.println("LOOP");
		}

		in.close();
	}
}
