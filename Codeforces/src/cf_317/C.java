package cf_317;

//package greedy;

import java.util.Scanner;

public class C {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] A(Scanner in) {
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[s.length];
		for (int i = 0; i < s.length; i++)
			n[i] = I(s[i]);
		return n;
	}

	public static boolean valid(long e) {
		for (int i = 0; i < N; i++) {
			e += (e - n[i]);
			if (e > Max) return true;
			if (e < 0) return false;
		}
		return true;
	}

	public static int bs(int l, int h) {
		if (h < l) return l;
		int m = (l + h) / 2;
		if (valid(m)) return bs(l, m - 1);
		else return bs(m + 1, h);
	}

	private static int N, Max;
	private static int[] n;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = I(in.nextLine());
		n = A(in);
		Max = -1;
		for (int i = 0; i < N; i++)
			if (n[i] > Max) Max = n[i];
		int max_e = bs(0, Max);
		System.out.println(max_e);
		in.close();
	}
}
