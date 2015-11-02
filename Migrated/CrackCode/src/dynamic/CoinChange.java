package dynamic;

import java.util.Arrays;

public class CoinChange {

	private static int[] coins;
	private static int len;
	private static long[][] mem;

	public static long cntChange(int[] Coins, int val) {
		coins = Coins;
		len = Coins.length;
		mem = new long[len][val + 1];
		Arrays.sort(coins);
		for (int i = 0; i < len; i++)
			Arrays.fill(mem[i], -1);
		return cntChange(0, val);
	}

	private static long cntChange(int i, int rem) {
		if (rem == 0) return 1;
		if (i >= len || rem < coins[i]) return 0;
		if (mem[i][rem] != -1) return mem[i][rem];
		mem[i][rem] = cntChange(i + 1, rem) + cntChange(i, rem - coins[i]);
		return mem[i][rem];
	}

	public static void main(String[] args) {
		int[] c = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };

		long v = cntChange(c, 100000);
		System.out.println("Count Ways: " + v);
	}

}
