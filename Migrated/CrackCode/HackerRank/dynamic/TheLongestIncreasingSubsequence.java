package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class TheLongestIncreasingSubsequence {

	public static int LIS(int[] n) {
		int N = n.length, max = 1;
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0; j--)
				if (n[i] > n[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int[] vals = new int[M];
		for (int i = 0; i < M; i++)
			vals[i] = in.nextInt();
		System.out.println(LIS(vals));
		in.close();
	}

}
