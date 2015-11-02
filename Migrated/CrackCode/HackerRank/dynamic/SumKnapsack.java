package dynamic;

import java.util.Scanner;

public class SumKnapsack {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine().trim());
		while (T-- > 0) {
			String[] s = in.nextLine().split("\\s+");
			int N = I(s[0]), K = I(s[1]), L = 2001;
			s = in.nextLine().split("\\s+");
			int[] n = new int[N];
			boolean[] f = new boolean[L];
			for (int i = 0; i < N; i++) {
				n[i] = I(s[i]);
				f[n[i]] = true;
			}
			for (int i = 1; i < L; i++) {
				for (int j = i - 1; j > 0 && !f[i]; j--)
					if (f[j]) f[i] |= f[i - j];
			}
			for (int k = K; k > 0; K++)
				if (f[k]) {
					System.out.println(k);
					break;
				}
		}
		in.close();
	}
}
