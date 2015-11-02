package euler;

import java.math.BigInteger;
import java.util.Scanner;

public class Euler_048 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long[] sum = { 1, 405071317, 9027641920l, 9110846700l, 6237204500l,
				3031782500l, 4077562500l };
		long val = 0l, MAX = 10000000000l;
		BigInteger M = BigInteger.valueOf(MAX);
		int N = in.nextInt();
		int base = (int) Math.log10(N);
		val = sum[base];
		for (int i = (int) (Math.pow(10, base) + 1); i <= N; i++) {
			BigInteger I = BigInteger.valueOf(i);
			val += I.modPow(I, M).longValue();
			if (val >= MAX) val -= MAX;
		}
		System.out.println(val);
		in.close();
	}
}
