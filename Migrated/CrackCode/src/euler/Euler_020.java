package euler;

import java.math.BigInteger;
import java.util.Scanner;

public class Euler_020 {

	private static long[] dsum = new long[1001];
	private static BigInteger val = BigInteger.valueOf(1l);
	private static int cnt = 0;
	static {
		dsum[0] = 1l;
	}

	public static long sum(char[] n) {
		long sum = 0l;
		for (int i = 0; i < n.length; i++)
			sum += n[i] - '0';
		return sum;
	}

	public static long ans(int v) {
		if (v > cnt) {
			for (int i = cnt + 1; i <= v; i++) {
				val = val.multiply(BigInteger.valueOf(i));
				dsum[i] = sum(val.toString().toCharArray());
			}
			cnt = v;
		}
		return dsum[v];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), v;
		while (T-- > 0) {
			v = in.nextInt();
			System.out.println(ans(v));
		}
		in.close();
	}
}
