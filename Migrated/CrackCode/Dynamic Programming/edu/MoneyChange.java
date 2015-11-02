package edu;

import java.util.Arrays;

public class MoneyChange {

	private static int[] ch;
	private static int N;
	private static int[][] mem;

	public static int CountChange(int[] change, int val) {
		ch = change;
		N = change.length;
		Arrays.sort(ch);
		mem = new int[val + 1][N];
		return cntChange(val, 0);
	}

	public static int CountChange_LOOP(int[] change, int val) {
		ch = change;
		N = change.length;
		Arrays.sort(ch);
		mem = new int[val + 1][N];
		return cntChange_loop(val, 0);
	}

	private static int cntChange_loop(int v, int i) {
		if (v == 0) return 1;
		if (i == N || v < ch[i]) return 0;
		if (mem[v][i] > 0) return mem[v][i];
		for (int j = 0; v >= ch[i] * j; j++)
			mem[v][i] += cntChange_loop(v - ch[i] * j, i + 1);
		return mem[v][i];
	}

	private static int cntChange(int v, int i) {
		if (v == 0) return 1;
		if (i == N || v < ch[i]) return 0;
		if (mem[v][i] > 0) return mem[v][i];
		mem[v][i] += cntChange(v - ch[i], i);
		mem[v][i] += cntChange(v, i + 1);
		return mem[v][i];
	}

	public static int CountChange_Dp(int[] change, int val) {
		ch = change;
		N = change.length;
		Arrays.sort(ch);
		mem = new int[val + 1][N + 1];
		for (int i = 0; i <= N; i++)
			mem[0][i] = 1;
		for (int v = ch[0]; v <= val; v += ch[0]) {
			for (int i = 1; i <= N; i++) {
				mem[v][i] = mem[v][i - 1];
				if (v >= ch[i - 1]) mem[v][i] += mem[v - ch[i - 1]][i];
			}
		}
		return mem[val][N];
	}

	public static int CountChange_Dp_Rolling(int[] change, int val) {
		ch = change;
		N = change.length;
		Arrays.sort(ch);
		mem = new int[val + 1][2];
		mem[0][0] = 1;
		mem[0][1] = 1;
		for (int i = 1; i <= N; i++) {
			for (int v = ch[0]; v <= val; v += ch[0]) {
				mem[v][i % 2] = mem[v][(i - 1) % 2];
				if (v >= ch[i - 1]) mem[v][i % 2] += mem[v - ch[i - 1]][i % 2];
			}
		}
		return mem[val][N % 2];
	}

	public static int CountChange_Dp_Rolling_Optimal(int[] change, int val) {
		ch = change;
		N = change.length;
		Arrays.sort(ch);
		int[] dp = new int[val + 1];
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int v = ch[0]; v <= val; v += ch[0]) {
				if (v >= ch[i - 1]) dp[v] += dp[v - ch[i - 1]];
			}
		}
		return dp[val];
	}

	public static void main(String[] args) {
		int[] ch = { 1, 5, 10, 20, 50, 100, 200 };
		int val = 267;
		System.out.println(CountChange(ch, val));
		System.out.println(CountChange_Dp(ch, val));
		System.out.println(CountChange_Dp_Rolling(ch, val));
		System.out.println(CountChange_Dp_Rolling_Optimal(ch, val));
	}

}
