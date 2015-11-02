package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CoinChange {

	private static int[] c;
	private static int N;
	private static long[][] mem;

	public static long TD_CoinChange(int[] coins, int value) {
		c = coins;
		Arrays.sort(c);
		N = coins.length;
		mem = new long[N][value + 1];
		for (long[] m : mem)
			Arrays.fill(m, -1);
		return cntCoinChange(0, value);
	}

	private static long cntCoinChange(int i, int rem) {
		if (i == N || rem < c[i]) return rem == 0l ? 1 : 0;
		if (mem[i][rem] >= 0) return mem[i][rem];
		mem[i][rem] = cntCoinChange(i + 1, rem);
		mem[i][rem] += cntCoinChange(i, rem - c[i]);
		return mem[i][rem];
	}

	public static void print(Stack<Integer> coins) {
		ArrayList<Integer> lis = new ArrayList<Integer>(coins);
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (Integer coin : lis)
			sb.append(coin).append(" ");
		sb.append("]");
		System.out.println(sb.toString());
	}

	public static long BU_CoinChange(int[] coins, int value) {
		Arrays.sort(coins);
		int N = coins.length;
		long[][] dp = new long[N + 1][value + 1];
		for (int i = 0; i <= N; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int c = 1; c <= value; c++) {
				dp[i][c] = dp[i - 1][c];
				dp[i][c] += coins[i - 1] <= c ? dp[i][c - coins[i - 1]] : 0;
			}
		}
		return dp[N][value];
	}

	public static long BU_CoinChangeSimple(int[] coins, int value) {
		Arrays.sort(coins);
		int N = coins.length;
		long[] dp = new long[value + 1];
		dp[0] = 1;
		for (int i = 0; i < N; i++)
			for (int c = 1; c <= value; c++)
				dp[c] += coins[i] <= c ? dp[c - coins[i]] : 0;
		return dp[value];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int value = 10;
		System.out.println(TD_CoinChange(coins, value));
		System.out.println(BU_CoinChange(coins, value));
		System.out.println(BU_CoinChangeSimple(coins, value));
	}

}
