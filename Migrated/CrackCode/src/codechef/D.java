package codechef;

import java.math.BigInteger;
import java.util.Scanner;

public class D {
	public static long[] v5 = { 1, 1, 4, 108, 27648, 86400000 };
	public static BigInteger[] v;

	public static void Gen(int N) {
		v = new BigInteger[N + 1];
		BigInteger I = BigInteger.valueOf(6);
		for (int i = 0; i < 6; i++)
			v[i] = BigInteger.valueOf(v5[i]);
		for (int i = 6; i <= N; i++) {
			v[i] = v[i - 1].multiply(I.pow(i));
			I = I.add(BigInteger.ONE);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		int N, Q;
		long m;
		String[] ss;
		while (T-- > 0) {
			ss = in.nextLine().trim().split(" ");
			N = Integer.parseInt(ss[0]);
			m = Long.parseLong(ss[1]);
			Q = Integer.parseInt(ss[2]);
			BigInteger M = BigInteger.valueOf(m);
			// System.out.println(Arrays.toString(v));
			if (N <= 5) {
				while (Q-- > 0) {
					int r = Integer.parseInt(in.nextLine());
					// System.out.println(v[N] + " , " + v[N - r] + " , " +
					// v[r]);
					System.out.println((v5[N] / (v5[r] * v5[N - r])) % m);
				}
			} else {
				Gen(N);
				while (Q-- > 0) {
					int r = Integer.parseInt(in.nextLine());
					// System.out.println(v[N] + " , " + v[N - r] + " , " +
					// v[r]);
					System.out.println(v[N]
							.mod(M)
							.divide((v[r].modInverse(M).multiply(v[N - r]
									.modInverse(M)))).mod(M));
				}
			}
		}
		in.close();
	}
}
