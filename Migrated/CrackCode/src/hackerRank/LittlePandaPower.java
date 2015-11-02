package hackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class LittlePandaPower {

	public static Long modArith(int a, int b, int x) {
		BigInteger A = BigInteger.valueOf(a);
		BigInteger B = BigInteger.valueOf(Math.abs(b));
		BigInteger X = BigInteger.valueOf(x);
		if (b < 0) A = A.modInverse(X);
		BigInteger val = A.modPow(B, X);

		return val.longValue();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine().trim()), a, b, x;
		while (T-- > 0) {
			String[] ss = in.nextLine().trim().split(" ");
			a = Integer.parseInt(ss[0].trim());
			b = Integer.parseInt(ss[1].trim());
			x = Integer.parseInt(ss[2].trim());
			System.out.println(modArith(a, b, x));
		}

		in.close();
	}

}
