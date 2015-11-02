package euler;

import java.util.Scanner;

public class Euler_006 {

	private static long gcd(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	private static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), L = 41, v;
		long result = 1l;
		long[] lcms = new long[L];
		lcms[1] = result;
		for (int i = 2; i < L; i++) {
			result = lcm(result, i);
			lcms[i] = result;
		}
		while (T-- > 0) {
			v = in.nextInt();
			System.out.println(lcms[v]);
		}

		in.close();
	}
}
