package edu;

import java.util.Arrays;

public class UVA_CuttingSticks {

	private static short[] p;
	private static short l;
	private static int N;
	private static long[][] mem;

	public static long TD_CutStick(short[] pos, short len) {
		l = len;
		N = pos.length;
		p = new short[N + 2];
		p[0] = 0;
		for (int i = 0; i < N; i++)
			p[i + 1] = pos[i];
		p[N + 1] = l;
		mem = new long[N + 2][N + 2];
		for (long[] t : mem)
			Arrays.fill(t, -1);
		return cutStick(1, N + 1);
	}

	private static long cutStick(int i, int j) {
		if (j <= i) return 0;
		if (mem[i][j] >= 0) return mem[i][j];
		mem[i][j] = 1000000000;
		for (int k = i; k < j; k++)
			mem[i][j] = Math
					.min(mem[i][j], cutStick(i, k) + cutStick(k + 1, j));
		return mem[i][j] += (p[j] - p[i - 1]);
	}

	public static void main(String[] args) {
		short[] pos1 = { 25, 50, 75 };
		short len1 = 100;

		short[] pos2 = { 4, 5, 7, 8 };
		short len2 = 10;
		System.out.println(TD_CutStick(pos1, len1));
		System.out.println(TD_CutStick(pos2, len2));
	}

}
