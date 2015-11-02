package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class BricksGame {

	private static int[] st, sum, dp, mem;
	private static int sz;

	public static long MaxScore(int[] stack) {
		st = stack;
		sz = stack.length;
		sum = new int[sz];
		mem = new int[sz];
		Arrays.fill(mem, -1);
		int acc = 0;
		for (int i = 0; i < sz; i++) {
			acc += st[i];
			sum[i] = acc;
		}
		mem[0] = sum[0];
		mem[1] = sum[1];
		mem[2] = sum[2];
		return maxScore(sz - 1);
	}

	private static int maxScore(int i) {
		if (mem[i] >= 0) return mem[i];
		mem[i] = sum[i - 1] - maxScore(i - 1) + st[i];
		mem[i] = Math.max(mem[i], sum[i - 2] - maxScore(i - 2) + st[i]
				+ st[i - 1]);
		mem[i] = Math.max(mem[i], sum[i - 3] - maxScore(i - 3) + st[i]
				+ st[i - 1] + st[i - 2]);
		return mem[i];
	}

	public static long MaxScoreDP(int[] stack) {
		st = stack;
		sz = stack.length;
		sum = new int[sz];
		dp = new int[sz];
		int acc = 0;
		for (int i = 0; i < sz; i++) {
			acc += st[i];
			sum[i] = acc;
		}
		dp[0] = sum[0];
		dp[1] = sum[1];
		dp[2] = sum[2];
		for (int i = 3; i < sz; i++) {
			dp[i] = Math.max(
					Math.max(sum[i - 1] - dp[i - 1] + st[i], sum[i - 2]
							- dp[i - 2] + st[i] + st[i - 1]), sum[i - 3]
							- dp[i - 3] + st[i] + st[i - 1] + st[i - 2]);
		}
		return dp[sz - 1];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine().trim());
		while (T-- > 0) {
			int N = I(in.nextLine().trim());
			String[] s = in.nextLine().split("\\s+");
			int[] n = new int[N];
			for (int i = 0; i < N; i++)
				n[i] = I(s[N - 1 - i]);
			System.out.println(MaxScoreDP(n));
			System.out.println(MaxScore(n));
		}
		in.close();
	}
}
