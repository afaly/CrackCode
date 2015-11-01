package cf_312;

import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine().trim()), M = 0, V;
		int[] f = new int[1000001];
		int[] s = new int[1000001];
		int[] e = new int[1000001];
		Arrays.fill(s, -1);
		Arrays.fill(e, -1);
		String[] ss = in.nextLine().split("\\s+");
		for (int i = 0; i < N; i++) {
			V = I(ss[i]);
			f[V]++;
			if (f[V] > f[M]) M = V;
			if (s[V] == -1) s[V] = i;
			e[V] = i;
		}

		for (int i = 0; i < 1000001; i++) {
			if (f[i] == f[M] && ((e[i] - s[i]) + 1) < ((e[M] - s[M]) + 1)) M = i;
		}
		System.out.println((s[M] + 1) + " " + (e[M] + 1));
		in.close();
	}
}
