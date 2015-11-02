package src;

import java.util.Scanner;

public class B {

	private static final int M = 10;

	private static int SOL(int[] c) {
		int im = -1, score = Integer.MAX_VALUE;
		for (int i = M - 1; i >= 0; i--) {
			if (c[i] > 0) {
				im = i;
				break;
			}
		}
		if (im == -1) return 0;
		if (im <= 2) {
//			System.out.println(s + "\t Return: " + im);
			return im;
		}

		for (int i = 1; i < im; i++) {
			c[im]--;
			c[i]++;
			c[im - i]++;
			int val = SOL(c);
//			System.out.println(s + "Split : " + im + "[" + i + "," + (im - i)
//					+ "] SCORE = " + (val + 1));
			score = Math.min(score, val + 1);
			c[im]++;
			c[i]--;
			c[im - i]--;
		}
		for (int i = 0; i < M - 1; i++)
			c[i] = c[i + 1];
		score = Math.min(score, SOL(c) + 1);
		return score;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for (int t = 1; t <= T; t++) {
			int D = Integer.parseInt(in.nextLine());
			String[] s = in.nextLine().split("\\s+");
			int[] c = new int[M];
			for (int d = 0; d < D; d++) {
				int val = Integer.parseInt(s[d]);
				c[val]++;
			}
			int score = SOL(c);
			System.out.println("Case #" + t + ": " + score);
		}

		in.close();
	}
}
