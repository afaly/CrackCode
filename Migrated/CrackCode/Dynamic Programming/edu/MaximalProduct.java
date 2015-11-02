package edu;

import java.util.Arrays;

public class MaximalProduct {

	private static int K;
	private static long[][] mem;

	public static long Product(int v, int k) {
		mem = new long[v + 1][k + 1];
		for (int i = 0; i <= v; i++)
			Arrays.fill(mem[i], -1);
		return (K = k) > v ? 0 : product(v, 0);
	}

	private static long product(int v, int k) {
		if (v == 1 || v == 0 || k >= K) return k == K ? 1 : 0;
		if (mem[v][k] >= 0) return mem[v][k];
		for (int i = 1; i <= v - (K - k) + 1; i++)
			mem[v][k] = Math.max(mem[v][k], i * product(v - i, k + 1));
		return mem[v][k];
	}

	public static void main(String[] args) {
		System.out.println(Product(6, 2));
	}

}
