package HackAug15;

import java.util.Arrays;
import java.util.Scanner;

public class BagsOfApples {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	private static int[] n;
	private static int[][] dp;
	private static int N;

	public static int MaxApples() {
		dp = new int[N][3];
		for (int[] t : dp)
			Arrays.fill(t, -1);
		return go(0, 0);
	}

	public static int Apples() {
		dp = new int[N][3];
		dp[0][n[0] % 3] = n[0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0];
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 1][2];
			int r = n[i] % 3;

		}
		return 0;
	}

	public static int go(int i, int val) {
		if (i == N) return val % 3 == 0 ? 1 : 0;
		if (dp[i][val % 3] != -1) return dp[i][val % 3];
		return dp[i][val % 3] = Math.max(go(i + 1, val), go(i + 1, val + n[i]));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = I(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		n = new int[N];
		for (int i = 0; i < N; i++)
			n[i] = I(s[i]);
		System.out.println(MaxApples());
		in.close();
	}
}
