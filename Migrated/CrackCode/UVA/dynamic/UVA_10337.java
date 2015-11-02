package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_10337 {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[][] w;
	public static long[][] dp;
	public static int x;

	public static long MinFuel() {
		dp = new long[10][x];
		for (long[] m : dp)
			Arrays.fill(m, -1);
		return minFuel(0, 0);
	}

	private static long minFuel(int i, int j) {
		if (j == x) return 0;
		if (dp[i][j] >= 0) return dp[i][j];
		dp[i][j] = Integer.MAX_VALUE;
		if ((x - j) - 1 >= i) dp[i][j] = Math.min(dp[i][j],
				30 + minFuel(i, j + 1));
		if (i > 0) dp[i][j] = Math.min(dp[i][j], 20 + minFuel(i - 1, j + 1));
		if (i < 9 && (x - j) - 1 > i) dp[i][j] = Math.min(dp[i][j],
				60 + minFuel(i + 1, j + 1));
		return dp[i][j] -= w[i][j];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		while (N-- > 0) {
			x = in.nextInt() / 100;
			w = new int[10][x];
			for (int h = 9; h >= 0; h--) {
				for (int d = 0; d < x; d++) {
					w[h][d] = in.nextInt();
				}
			}
			System.out.println(MinFuel());
			System.out.println();
		}

		in.close();
	}
}
