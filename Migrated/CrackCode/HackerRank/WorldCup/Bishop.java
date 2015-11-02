package WorldCup;

import java.util.Scanner;

public class Bishop {

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

	private static int N, M, V;
	private static int[] m;

	public static int CntMoves(int i, int b) {
		if (i == N) return 1;
		int k = (b << 1) | (b >> 1), t = (k | m[i]) & V, r = (k & ~m[i]) & V, cnt = 0;
		String st = Integer.toBinaryString(t), sr = Integer.toBinaryString(r);
		for (int j = M - 1; j >= 0; j--) {
			if (((t >> j) & 1) == 0 && ((m[i] >> j) & 1) == 0) {
				cnt += CntMoves(i + 1, (r | 1 << j) & V);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] p = IA(in.nextLine());
		N = p[0];
		M = p[1];
		V = (1 << M) - 1;
		m = new int[N];
		for (int i = 0; i < N; i++) {
			char[] c = in.nextLine().toCharArray();
			for (int j = 0, k = M - 1; j < M; j++, k--)
				if (c[j] == '*') m[i] |= (1 << k);
		}
		System.out.println(CntMoves(0, 0));
		in.close();
	}
}
