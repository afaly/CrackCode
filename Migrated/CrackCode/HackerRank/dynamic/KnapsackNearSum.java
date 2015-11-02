package dynamic;

import java.util.Scanner;

public class KnapsackNearSum {

	private static boolean[] n;
	private static int L = 2001;

	public static int nearSum(int K, int[] a) {
		n = new boolean[L];
		for (int i = 0; i < a.length; i++)
			n[a[i]] = true;
		for (int i = 0; i < L; i++) {
			if (!n[i]) {
				for (int j = 0; j < i && !n[i]; j++)
					n[i] = n[j] & n[i - j];
			}
		}
		for (int i = K; i >= 0; i++)
			if (n[i]) return i;
		return 0;

	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		String[] s;
		int[] a;
		while (T-- > 0) {
			s = in.nextLine().split("\\s+");
			int N = I(s[0]), K = I(s[1]);
			a = new int[N];
			s = in.nextLine().split("\\s+");
			for (int i = 0; i < N; i++)
				a[i] = I(s[i]);
			System.out.println(nearSum(K, a));
		}

		in.close();
	}

}
