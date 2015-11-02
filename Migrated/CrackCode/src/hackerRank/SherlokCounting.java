package hackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class SherlokCounting {

	public static BigInteger sqrt(BigInteger n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8"))
				.toString());
		while (b.compareTo(a) >= 0) {
			BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
			if (mid.multiply(mid).compareTo(n) > 0) b = mid
					.subtract(BigInteger.ONE);
			else a = mid.add(BigInteger.ONE);
		}
		return a.subtract(BigInteger.ONE);
	}

	public static long Count(int N, int K) {
		// long cnt = 0;
		if (K >= N) {
			return (N - 1);
		} else if (N <= (K * 4)) {
			return (long) (Math.floor(Math.sqrt(N) * Math.sqrt(K)));
		} else {
			return (long) (Math.round(Math.sqrt(N)) * 2);
		}
		// if (N - K - 1 <= K) {
		// cnt += N - 1;
		// } else {
		// cnt += 2 * K;
		// double val = Math.floor(Math.sqrt(N) * Math.sqrt(K));
		// cnt += (long) (val - K - 1);
		// }
		// return cnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine()), N, K;
		String[] s = null;
		for (int t = 0; t < T; t++) {
			s = in.nextLine().split(" ");
			N = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			System.out.println(Count(N, K));
		}
		in.close();

	}

}
