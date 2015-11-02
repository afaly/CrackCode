package hackerRank;

import java.util.Random;
import java.util.Scanner;

public class ORNGSeqGen {

	public static int[] v = new int[10];

	public static Random check(long seed) {
		Random r = new Random(seed);
		for (int i = 0; i < 10; i++) {
			if (v[i] != r.nextInt(1000))
				return null;
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long t1, t2, ts;
		Random r = null;
		for (int t = 0; t < T; t++) {
			t1 = in.nextLong();
			t2 = in.nextLong();
			for (int i = 0; i < 10; i++)
				v[i] = in.nextInt();
			for (ts = t1; ts <= t2; ts++) {
				r = check(ts);
				if (r != null)
					break;
			}
			System.out.print(ts + " ");
			for (int i = 0; i < 9; i++) {
				System.out.print(r.nextInt(1000) + " ");
			}
			System.out.print(r.nextInt(1000) + "\n");
		}
		in.close();
	}
}
