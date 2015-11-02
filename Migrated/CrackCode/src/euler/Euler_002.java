package euler;

import java.util.Arrays;
import java.util.Scanner;

public class Euler_002 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long v;
		long[] f = new long[90], s = new long[90];
		f[0] = 1l;
		f[1] = 1l;
		s[0] = 0l;
		s[1] = 0l;
		int cnt = 2;
		long sum = 0l;
		while (cnt < 90) {
			f[cnt] = f[cnt - 1] + f[cnt - 2];
			if ((f[cnt] & 1) == 0) sum += f[cnt];
			s[cnt] = sum;
			cnt++;
		}
		// for (int i = 0; i < 90; i++)
		// System.out.println(i + " ::  " + f[i] + " : " + s[i]);

		while (T-- > 0) {
			v = in.nextLong();
			int idx = Arrays.binarySearch(f, v);
			// System.out.println(idx);
			if (idx >= 0) System.out.println(s[idx]);
			else System.out.println(s[-idx - 2]);
		}

		in.close();
	}
}
