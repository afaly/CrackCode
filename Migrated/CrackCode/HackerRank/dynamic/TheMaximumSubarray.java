package dynamic;

import java.util.Scanner;

public class TheMaximumSubarray {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long sumNonContigous(int[] n, int N) {
		long sum = 0l, max = Integer.MIN_VALUE;
		boolean valid = false;
		for (int i = 0; i < N; i++) {
			if (n[i] >= 0) {
				sum += n[i];
				valid = true;
			} else
				max = Math.max(max, n[i]);
		}
		return valid ? sum : max;
	}

	public static long sumContigous(int[] n, int N) {
		long[] m = new long[N];
		long max = Long.MIN_VALUE;
		m[0] = n[0];
		for (int i = 1; i < N; i++)
			m[i] = Math.max(m[i - 1] + n[i], n[i]);
		for (int i = 0; i < N; i++)
			max = Math.max(max, m[i]);
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine().trim());
		while (T-- > 0) {
			int N = I(in.nextLine().trim());
			String[] s = in.nextLine().trim().split("\\s+");
			int[] n = new int[N];
			for (int i = 0; i < N; i++)
				n[i] = I(s[i]);
			System.out
					.println(sumContigous(n, N) + " " + sumNonContigous(n, N));

		}
		in.close();
	}

}
