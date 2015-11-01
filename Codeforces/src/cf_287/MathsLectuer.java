package cf_287;

import java.math.BigInteger;
import java.util.Scanner;

public class MathsLectuer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long k = in.nextLong();
		long m = in.nextLong();

		BigInteger kk = BigInteger.valueOf(k);
		BigInteger r = BigInteger.valueOf(k);
		BigInteger T = BigInteger.valueOf(0);
		BigInteger M = BigInteger.valueOf(m);
		BigInteger d9 = BigInteger.valueOf(9);
		int len = r.toString().length();
		while (len <= n) {
			long h = n - len;
			if (h > 1)
				T = T.add((d9.multiply(BigInteger.valueOf(10).modPow(
						BigInteger.valueOf(h - 1), M)).mod(M)));
			else if (h > 0)
				T = T.add(d9);
			else
				T = T.add(BigInteger.ONE);
			T = T.mod(M);
			r = r.add(kk);
			len = r.toString().length();
		}
		System.out.println(T.toString());
		in.close();
	}

}
