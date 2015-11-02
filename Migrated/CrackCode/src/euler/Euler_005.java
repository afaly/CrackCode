package euler;

import java.util.Scanner;

public class Euler_005 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), L = 10000, v;
		long[] p = new long[L];
		boolean[] f = new boolean[1000000];
		int cnt = 0;
		for (int i = 2; i < 1000000 && cnt < L; i++) {
			if (!f[i]) {
				p[cnt++] = i;
				for (int j = i; j < 1000000; j += i) {
					f[j] = true;
				}
			}
		}
		while (T-- > 0) {
			v = in.nextInt();
			System.out.println(p[v - 1]);
		}

		in.close();
	}
}
