package cf_297;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static class Pair {
		int i, j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	private static boolean[][] v;
	private static char[][] m, x;
	private static int N, M, OO = Integer.MAX_VALUE;
	private static int[] vals;
	private static int[] dx = { 0, 0, 1, -1 }, dy = { -1, 1, 0, 0 };

	private static boolean valid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static void DFS(int i, int j) {
		if (!valid(i, j)) return;
		if (v[i][j] || m[i][j] == '*') return;
		v[i][j] = true;
		for (int k = 0; k < 4; k++)
			DFS(i + dx[k], j + dy[k]);
		if (i < vals[0]) vals[0] = i;
		if (i > vals[1]) vals[1] = i;
		if (j < vals[2]) vals[2] = j;
		if (j > vals[3]) vals[3] = j;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		m = new char[N][M];
		x = new char[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			m[i] = in.nextLine().toCharArray();
			Arrays.fill(x[i], '*');
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j] && m[i][j] == '.') {
					vals = new int[] { OO, -OO, OO, -OO };
					DFS(i, j);
					for (int ii = vals[0]; ii <= vals[1]; ii++) {
						for (int jj = vals[2]; jj <= vals[3]; jj++) {
							x[ii][jj] = '.';
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++)
			System.out.println(new String(x[i]));

		in.close();
	}
}

// '***..*......*...****.*****.*.....**.*******.******.*..***.***.**'
// '***..*......*...****.*****.*.....**.*******.******.*..***.***.**'

