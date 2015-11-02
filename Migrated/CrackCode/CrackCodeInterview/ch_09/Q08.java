package ch_09;

import java.util.Arrays;

public class Q08 {

	private static long[][] mem;
	private static int[] change = { 25, 10, 5, 1 };

	public static long CountChange(int val, int[] changeCoins) {
		change = changeCoins;
		mem = new long[val + 1][change.length];
		return val <= 0 ? 0 : cntChange(val, 0);
	}

	private static long cntChange(int n, int j) {
		if (n == 0) return 1;
		if (j == change.length - 1 && n % change[j] == 0) return 1;
		if (j >= change.length) return 0;
		if (mem[n][j] > 0) return mem[n][j];
		for (int i = 0; i * change[j] <= n; i++) {
			mem[n][j] += cntChange(n - (i * change[j]), j + 1);
		}
		return mem[n][j];
	}

	public static long CountChangeDP(int val, int[] changeCoins) {
		change = changeCoins;
		Arrays.sort(change);
		return val <= 0 ? 0 : cntChangeDP(val);
	}

	private static long cntChangeDP(int val) {
		long[][] cnt = new long[change.length + 1][val + 1];
		for (int i = 0; i <= change.length; i++)
			cnt[i][0] = 1;

		for (int i = 1; i <= change.length; i++) {
			for (int j = 1; j <= val; j++) {
				cnt[i][j] = cnt[i - 1][j];
				if (j >= change[i - 1]) cnt[i][j] += cnt[i][j - change[i - 1]];
			}
		}

		return cnt[change.length][val];
	}

	public static void main(String[] args) {
		for (int n = 0; n <= 100; n++)
			System.out.println(n + " : " + CountChange(n, new int[] { 7, 3 })
					+ "  |  " + CountChangeDP(n, new int[] { 7, 3 }));
	}

}
