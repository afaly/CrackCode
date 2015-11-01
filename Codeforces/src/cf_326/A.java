package cf_326;

import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		int[] a = new int[N];
		int[] p = new int[N];
		int[] s = new int[N];
		for (int i = 0; i < N; i++) {
			int[] x = IA(in.nextLine());
			a[i] = x[0];
			p[i] = x[1];
		}
		in.close();
	}
}
