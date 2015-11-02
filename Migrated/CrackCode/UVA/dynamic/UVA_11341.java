package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_11341 {

	public static int[][] h;
	public static double[][] dp;
	public static int N, M;

	public static double Average() {
		dp = new double[N][M];
		for (double[] t : dp)
			Arrays.fill(t, Integer.MIN_VALUE);
		return avg(0, 0, 0, 0);
	}

	private static double avg(int i, int j, int m, double a) {
		if (i == N) return a / N >= 5 ? a / N : Integer.MIN_VALUE;
		if (dp[i][j] >= 0) return dp[i][j];
		for (int k = 1; k <= (M - m) - ((N - i) - 1); k++) {
			if (h[i][k - 1] >= 5) {
				dp[i][j] = Math.max(dp[i][j],
						avg(i + 1, k, m + k, a + h[i][k - 1]));
			}
		}
		return dp[i][j];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			N = in.nextInt();
			M = in.nextInt();
			h = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					h[i][j] = in.nextInt();
				}
			}
			double res = Average();
			System.out.println(res > 0 ? "Maximal possible average mark - "
					+ res + "."
					: "Peter, you shouldn't have played billiard that much.");
			System.out.println();
		}

		in.close();
	}
}
