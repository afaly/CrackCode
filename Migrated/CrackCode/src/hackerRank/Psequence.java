package hackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class Psequence {

	private static int M = 1000000007;
	private static BigInteger BM = BigInteger.valueOf(M);

	public static int Count(int N, int P) {
		long pairs = 0, sim = 0;
		for (int i = 1; i <= P; i++) {
			pairs += (P - (P / i));
		}
		BigInteger cnt = BigInteger.valueOf(P).pow(N);
		BigInteger prs = BigInteger.valueOf(P).pow(N - 2);

		prs = prs.multiply(BigInteger.valueOf(N - 1));
		prs = prs.multiply(BigInteger.valueOf(pairs));

		BigInteger res = cnt.subtract(prs);
		if (N > 2)
			res = res.add(BigInteger.valueOf(sim));
		System.out.println(cnt + " , " + prs + " , " + res + " , " + sim
				+ " , " + pairs);
		return res.mod(BM).intValue();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N, P;
		N = in.nextInt();
		P = in.nextInt();
		System.out.println(Count(N, P));
		in.close();

	}

}
