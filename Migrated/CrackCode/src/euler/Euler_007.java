package euler;

import java.util.Scanner;

public class Euler_007 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), L = 10001, v;
		long sum = 0l;
		long[] s = new long[L];
		for (int i = 0; i < L; i++) {
			sum += i * i;
			s[i] = sum;
		}
		while (T-- > 0) {
			v = in.nextInt();
			long ans = (v * (v + 1) / 2);
			ans *= ans;
			ans -= s[v];
			System.out.println(ans);
		}

		in.close();
	}
}
