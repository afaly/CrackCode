package may;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static final long M = 1000000007l;

	public static void main(String[] args) {
		System.out.println(M * M);
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		while (T-- > 0) {
			int N = I(in.nextLine());
			String[] s = in.nextLine().split("\\s+");
			long[] v = new long[N];
			long[] p = new long[N];
			for (int i = 0; i < N; i++)
				v[i] = I(s[i]);

			Arrays.sort(v);
			long pow = 1;
			p[0] = 1;
			for (int i = 1; i < N; i++) {
				pow = (pow << 1) % M;
				p[i] = pow;
			}
			long sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long diff = v[j] - v[i];
					long val = p[j - i - 1] * diff;
					if (val > M) val %= M;
					sum += val;
				}
			}

			System.out.println(sum);
		}
		in.close();
	}
}
