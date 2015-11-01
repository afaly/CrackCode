package cf_311;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static boolean V(double val, double W) {
		return Math.abs(val - W) < 1e-19;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), W = I(s[1]), N3 = 3 * N;
		int[] n = new int[2 * N];
		s = in.nextLine().split("\\s+");
		for (int i = 0; i < 2 * N; i++)
			n[i] = I(s[i]);
		Arrays.sort(n);
		double ming = 0, val = 0, maxg = n[0], maxb = n[N], j = maxg, k = ming, i = (j + k) / 2;
		boolean solved = false;
		while (!solved) {
			val = (N3 * i);
			if (i <= maxg && 2 * i <= maxb && N3 * i <= W) k = i;
			else
				j = i;
			if (V((j + k) / 2, i)) solved = true;
			i = (j + k) / 2;
		}
		System.out.println(val);
		in.close();
	}
}
