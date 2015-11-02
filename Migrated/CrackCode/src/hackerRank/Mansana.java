package hackerRank;

import java.util.Scanner;

public class Mansana {

	private static long[] n5 = new long[25];

	private static void Start() {
		long v = 1;
		for (int i = 0; i < n5.length; i++) {
			n5[i] = v;
			v *= 5;
		}
	}

	public static long Factorial(long n) {
		long v = 5 * n, nn = n, vv, nnn;
		int p, i, ii, pp;
		for (i = 0, p = 0; i < n5.length; i++) {
			if (n5[i] < v) {
				nn += (i - 1);
			}
			p += i;
		}
		i--;
		nn = ((n + i) - p);
		vv = 5 * nn;

		for (ii = 0, pp = 0; ii < n5.length; ii++) {
			if (n5[ii] > vv)
				break;
			pp += ii;
		}

		nnn = (((n + ii) - pp) - 1);
		if (nn == nnn)
			return 5 * nn;
		else
			return 5 * (nn + ii - 1);
	}

	public static void main(String[] args) {
		Start();
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		long N;
		for (int t = 0; t < T; t++) {
			N = Long.parseLong(in.nextLine());
			System.out.println(Factorial(N));
		}
		in.close();
	}

}