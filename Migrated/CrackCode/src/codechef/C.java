package codechef;

import java.util.Scanner;

public class C {

	private static long[] S;
	static {
		long v = 1, p = 1;
		int k = 0;
		S = new long[40];
		S[k++] = 1;
		while (v <= 1e12) {
			p <<= 1;
			v += p;
			S[k++] = v;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		long X, K;
		String[] ss;
		while (T-- > 0) {
			ss = in.nextLine().trim().split(" ");
			X = Long.parseLong(ss[0]);
			K = Long.parseLong(ss[1]);
			for (int i = 39; i >= 0; i--) {
				if (K >= S[i]) {
					if (K != S[i]) i++;
					double v1 = Math.pow(2, i), v2 = Math.pow(2, i + 1);
					double xx = (X * 1.0) / v2;
					double dd = (X * 1.0) / v1;
					double pp = xx + (K - v1) * dd;
					System.out.printf("%f\n", pp);
					break;
				}
			}
		}
		in.close();
	}
}
