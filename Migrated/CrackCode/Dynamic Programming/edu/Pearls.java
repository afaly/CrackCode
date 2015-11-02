package edu;

import java.util.Arrays;
import java.util.Scanner;

public class Pearls {

	private static int[] c, s;
	private static int N;
	private static long[][] mem;

	public static long TD_MinCost(int[] cost, int[] shop) {
		c = cost;
		s = shop;
		N = shop.length;
		mem = new long[N][N];
		return minCost(0, 0, 0);
	}

	private static long minCost(int p, int i, int acc) {
		if (i == N) return acc == 0 ? 0 : 1000000000;
		if (mem[p][i] > 0) return mem[p][i];
		mem[p][i] = ((acc + s[i] + 10) * c[i]) + minCost(i + 1, i + 1, 0);
		mem[p][i] = Math.min(mem[p][i], minCost(p, i + 1, acc + s[i]));
		return mem[p][i];
	}

	public static long BU_MinCost(int[] cost, int[] shop) {
		c = cost;
		N = cost.length;
		s = new int[N];
		long[] by = new long[N + 1];
		long v1 = 0, v2 = 0, p = 0;
		s[0] = shop[0];
		for (int i = 1; i < N; i++)
			s[i] = s[i - 1] + shop[i];
		for (int i = 0; i < N; i++) {
			v1 = (s[i] + 10) * c[i];
			v2 = p + ((shop[i] + 10) * c[i]);
			if (v1 < v2) {
				p = v1;
				by[i + 1] = s[i];
				by[i] = 0;
			} else {
				p = v2;
				by[i + 1] = shop[i];
			}
		}
		System.out.println(Arrays.toString(by));
		return p;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		while (T-- > 0) {
			int N = I(in.nextLine());
			int[] cost = new int[N], shop = new int[N];
			for (int i = 0; i < N; i++) {
				String[] s = in.nextLine().split("\\s+");
				cost[i] = I(s[1]);
				shop[i] = I(s[0]);
			}
			System.out.println(TD_MinCost(cost, shop));
			System.out.println(BU_MinCost(cost, shop));
		}
		in.close();
	}
}
