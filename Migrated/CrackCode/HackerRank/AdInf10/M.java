package AdInf10;

import java.util.Arrays;

public class M {

	public static String Puzzle(String s) {
		System.out.println(s);
		char[] m = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		return m[Integer.parseInt(s.substring(0, s.length() - 4), 2)] + ""
				+ m[Integer.parseInt(s.substring(s.length() - 4), 2)];
	}

	public static int[] Puzzle(int[] a, int p) {
		if (p <= 1) return a;
		for (int i = 0; i < a.length; i++) {
			int v = ((a[i] < 0 && a[i] / p > -1 ? (int) Math
					.round((a[i] * 1.0 / p)) : a[i] / p) + 1);
			if (a[i] % p == 0) {
				if (a[i] < 0) a[i] = Math.min(v, 0) * p;
			} else {
				a[i] = a[i] < 0 ? Math.min(v, 0) * p : v * p;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		String s = "10001";
		// System.out.println(Arrays.toString(s.split("((?<=[\\s])|(?=[\\s]))")));
		StringBuilder sb;
		System.out.println(Puzzle(s));
		System.out.println(-75 % 11);
		System.out.println(2 % 1);
		System.out.println("--------------------------");
		String ss = "\u0017 ";
		int n = ss.split(" ").length, i, j;
		for (i = ss.indexOf(' '), j = 1; i < ss.length() && j < n; j++, i = ss
				.indexOf(' ', i + 1)) {
			System.out.println(ss.substring(i));
		}
		System.out.println(ss.substring(i + 1) + " " + ss.substring(0, i));
		System.out.println("00000000000000000000000000");
		System.out.println(Arrays.toString(Puzzle(
				new int[] { 22, -15, 46, 11 }, 3)));
	}

}
