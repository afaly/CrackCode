package cf_323;

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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		boolean[] h = new boolean[N];
		boolean[] v = new boolean[N];
		N *= N;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int[] p = IA(in.nextLine());
			if (!h[p[0] - 1] && !v[p[1] - 1]) {
				sb.append(i).append(" ");
				h[p[0] - 1] = true;
				v[p[1] - 1] = true;
			}
		}
		System.out.println(sb.toString().trim());
		in.close();
	}
}
