package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_825 {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	private static int N, M;
	private static boolean[][] m;
	private static long[][] dp;
	private static int[] dx = { 0, 1 }, dy = { 1, 0 };

	public static long countPaths(boolean[][] map, int NN, int MM) {
		N = NN;
		M = MM;
		m = map;
		dp = new long[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);
		return countPaths(0, 0);
	}

	private static boolean valid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	private static boolean goal(int i, int j) {
		return i == N - 1 && j == M - 1;
	}

	private static long countPaths(int i, int j) {
		if (goal(i, j)) return 1;
		if (!valid(i, j) || m[i][j]) return 0;
		if (dp[i][j] >= 0) return dp[i][j];
		return dp[i][j] = countPaths(i + dx[0], j + dy[0])
				+ countPaths(i + dx[1], j + dy[1]);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		String[] s;
		while (T-- > 0) {
			in.nextLine();
			s = in.nextLine().split("\\s+");
			int N = I(s[0]), M = I(s[1]);
			boolean[][] m = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				s = in.nextLine().split("\\s+");
				int idx = I(s[0]) - 1;
				for (int j = 1; j < s.length; j++)
					m[idx][I(s[j]) - 1] = true;
			}
			System.out.println(countPaths(m, N, M));
			if (T != 0) System.out.println();
		}
		in.close();
	}
}
