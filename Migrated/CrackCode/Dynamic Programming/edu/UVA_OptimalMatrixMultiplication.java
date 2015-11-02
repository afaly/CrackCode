package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_OptimalMatrixMultiplication {

	private static int[][] m;
	private static long[][] mem;
	private static int N;

	public static long MatrixMultiply(int[][] mats, int len) {
		N = len;
		m = mats;
		mem = new long[N][N];
		for (long[] t : mem)
			Arrays.fill(t, -1l);
		for (int i = 0; i < N - 1; i++)
			mem[i][i + 1] = m[i][0] * m[i][1] * m[i + 1][1];
		return matrixMultiply(0, N - 1);
	}

	private static long matrixMultiply(int i, int j) {
		if (j <= i) return 0;
		if (mem[i][j] >= 0) return mem[i][j];
		mem[i][j] = 10000000000l;
		for (int k = i; k < j; k++) {
			mem[i][j] = Math.min(mem[i][j], matrixMultiply(i, k)
					+ matrixMultiply(k + 1, j));
		}
		return mem[i][j] += (m[i][0] * m[i][1] * m[j][1]);
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		while (N > 0) {
			int[][] mats = new int[N][2];
			for (int i = 0; i < N; i++) {
				String[] s = in.nextLine().split("\\s+");
				mats[i][0] = I(s[0]);
				mats[i][1] = I(s[1]);
			}
			System.out.println(MatrixMultiply(mats, N));
			N = I(in.nextLine());
		}
		in.close();
	}

}
