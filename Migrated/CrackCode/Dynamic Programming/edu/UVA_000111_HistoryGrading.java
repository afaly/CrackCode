package edu;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_000111_HistoryGrading {

	private static int[] c, a;
	private static int N;
	private static int[][] mem;

	public static int BU_Grade(int[] correct, int[] answer) {
		c = correct;
		N = correct.length;
		a = answer;
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (c[i - 1] == a[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[N][N];
	}

	public static int TD_Grade(int[] correct, int[] answer) {
		c = correct;
		N = correct.length;
		a = answer;
		mem = new int[N][N];
		for (int[] t : mem)
			Arrays.fill(t, -1);
		return grade(0, 0);
	}

	private static int grade(int i, int j) {
		if (i == N || j == N) return 0;
		if (mem[i][j] >= 0) return mem[i][j];
		mem[i][j] = 0;
		if (c[i] == a[j]) mem[i][j] = Math.max(mem[i][j],
				1 + grade(i + 1, j + 1));
		else mem[i][j] = Math.max(grade(i + 1, j), grade(i, j + 1));
		return mem[i][j];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[Integer.parseInt(ss[i]) - 1] = i;
		return a;
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		I(in.nextLine());
		String s = in.nextLine();
		int[] correct = IA(s);
		s = in.nextLine();
		while (s != null && !s.isEmpty()) {
			int[] answers = IA(s);
			System.out.println(TD_Grade(correct, answers));
			System.out.println(BU_Grade(correct, answers));
			s = in.nextLine();
		}
		in.close();
	}
}
