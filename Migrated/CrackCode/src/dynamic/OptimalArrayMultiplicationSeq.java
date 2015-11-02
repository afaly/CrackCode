package dynamic;

import java.util.Scanner;

public class OptimalArrayMultiplicationSeq {

	private static int[][] mats;
	private static long[][] mi;
	private static String[][] ms;

	public static String MultMats(int[][] Maticies) {
		mats = Maticies;
		mi = new long[mats.length][mats.length];
		ms = new String[mats.length][mats.length];
		for (int i = 0; i < mats.length; i++) {
			ms[i][i] = String.format("A%d", (i + 1));
			if (i < mats.length - 1) {
				ms[i][i + 1] = String.format("(A%d x A%d)", (i + 1), (i + 2));
				mi[i][i + 1] = mats[i][0] * mats[i][1] * mats[i + 1][1];
			}
		}

		Mult(0, mats.length - 1);
		return ms[0][mats.length - 1];
	}

	private static long Mult(int i, int j) {
		if (i == j) return 0;
		if (mi[i][j] != 0) return mi[i][j];
		long min = Long.MAX_VALUE;
		int idx = -1;
		for (int k = i; k < j; k++) {
			long val = Mult(i, k) + Mult(k + 1, j)
					+ (mats[i][0] * mats[k][1] * mats[j][1]);
			if (val < min) {
				min = val;
				idx = k;
			}
		}
		mi[i][j] = min;
		ms[i][j] = "(" + ms[i][idx] + " x " + ms[idx + 1][j] + ")";
		return mi[i][j];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.parseInt(in.nextLine());
		int t = 0;
		while (len != 0) {
			String[] ss;
			int[][] mats = new int[len][2];
			for (int i = 0; i < len; i++) {
				ss = in.nextLine().split(" ");
				mats[i][0] = Integer.parseInt(ss[0]);
				mats[i][1] = Integer.parseInt(ss[1]);
			}
			System.out.printf("Case %d: %s\n", ++t, MultMats(mats));
			len = Integer.parseInt(in.nextLine());
		}
		in.close();
	}
}
