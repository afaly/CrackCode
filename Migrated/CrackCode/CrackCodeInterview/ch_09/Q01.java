package ch_09;

import java.util.Scanner;

public class Q01 {

	private static long mem[];

	public static long CountStairsDP(int n) {
		return n > 0 ? cntStairsDP(n) : 0;
	}

	private static long cntStairsDP(int n) {
		long[] cnt = new long[n + 1];
		cnt[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i >= 1) cnt[i] += cnt[i - 1];
			if (i >= 2) cnt[i] += cnt[i - 2];
			if (i >= 3) cnt[i] += cnt[i - 3];
		}
		return cnt[n];
	}

	public static long CountStairs(int n) {
		mem = new long[n + 1];
		return n > 0 ? cntStairs(n) : 0;
	}

	private static long cntStairs(int n) {
		if (n == 0) return 1;
		if (mem[n] > 0) return mem[n];
		long p1 = cntStairs(n - 1);
		long p2 = n >= 2 ? cntStairs(n - 2) : 0;
		long p3 = n >= 3 ? cntStairs(n - 3) : 0;
		mem[n] = p1 + p2 + p3;
		return mem[n];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 1; i < 30; i++)
			System.out.println(i + " : " + CountStairs(i) + "  |  "
					+ CountStairsDP(i));
		in.close();

	}
}
