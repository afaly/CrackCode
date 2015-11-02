package edu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UVA_000437_TheTowerOfBabylon {

	private static int[][] b;
	private static int N;
	private static long[][] mem;

	public static long BU_Babylon(int[][] blocks) {
		N = blocks.length;
		b = new int[N * 6][3];
		for (int i = 0, j = 0; i < N; i++) {
			b[j][0] = blocks[i][0];
			b[j][1] = blocks[i][1];
			b[j][2] = blocks[i][2];
			j++;
			b[j][0] = blocks[i][1];
			b[j][1] = blocks[i][2];
			b[j][2] = blocks[i][0];
			j++;
			b[j][0] = blocks[i][2];
			b[j][1] = blocks[i][0];
			b[j][2] = blocks[i][1];
			j++;
			b[j][0] = blocks[i][1];
			b[j][1] = blocks[i][0];
			b[j][2] = blocks[i][2];
			j++;
			b[j][0] = blocks[i][2];
			b[j][1] = blocks[i][1];
			b[j][2] = blocks[i][0];
			j++;
			b[j][0] = blocks[i][0];
			b[j][1] = blocks[i][2];
			b[j][2] = blocks[i][1];
			j++;
		}
		N *= 6;
		Arrays.sort(b, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				if (b[0] != a[0]) return a[0] - b[0];
				else if (b[1] != a[1]) return a[1] - b[1];
				return a[2] - b[2];
			}
		});

		long[] dp = new long[N];
		int idx = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (b[i][0] > b[j][0] && b[i][1] > b[j][1] && dp[i] < dp[j]) dp[i] = dp[j];

			}
			dp[i] += b[i][2];
			if (dp[i] > dp[idx]) idx = i;
		}

		return dp[idx];
	}

	public static long TD_Babylon(int[][] blocks) {
		N = blocks.length;
		b = new int[N * 6][3];
		for (int i = 0, j = 0; i < N; i++) {
			b[j][0] = blocks[i][0];
			b[j][1] = blocks[i][1];
			b[j][2] = blocks[i][2];
			j++;
			b[j][0] = blocks[i][1];
			b[j][1] = blocks[i][2];
			b[j][2] = blocks[i][0];
			j++;
			b[j][0] = blocks[i][2];
			b[j][1] = blocks[i][0];
			b[j][2] = blocks[i][1];
			j++;
			b[j][0] = blocks[i][1];
			b[j][1] = blocks[i][0];
			b[j][2] = blocks[i][2];
			j++;
			b[j][0] = blocks[i][2];
			b[j][1] = blocks[i][1];
			b[j][2] = blocks[i][0];
			j++;
			b[j][0] = blocks[i][0];
			b[j][1] = blocks[i][2];
			b[j][2] = blocks[i][1];
			j++;
		}
		N *= 6;
		Arrays.sort(b, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				if (b[0] != a[0]) return a[0] - b[0];
				else if (b[1] != a[1]) return a[1] - b[1];
				return a[2] - b[2];
			}
		});

		mem = new long[N + 1][N + 1];
		for (long[] t : mem)
			Arrays.fill(t, -1l);
		return babylon(0, 1);
	}

	private static long babylon(int p, int i) {
		if (i == N + 1
				|| (p > 0 && (b[p - 1][0] > b[i - 1][0] && b[p - 1][1] > b[i - 1][1]))) return 0;
		if (mem[p][i] >= 0) return mem[p][i];
		mem[p][i] = babylon(p, i + 1);
		if (p <= 0 || (b[p - 1][0] < b[i - 1][0] && b[p - 1][1] < b[i - 1][1])) mem[p][i] = Math
				.max(mem[p][i], b[i - 1][2] + babylon(i, i + 1));
		return mem[p][i];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		while (N > 0) {
			int[][] blks = new int[N][3];
			for (int i = 0; i < N; i++) {
				blks[i] = IA(in.nextLine());
			}
			System.out.println(TD_Babylon(blks));
			System.out.println(BU_Babylon(blks));
			N = I(in.nextLine());
		}
		in.close();
	}
}
