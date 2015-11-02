package dynamic;

import java.util.Scanner;

public class CutTree {

	private static boolean[][] e;
	private static int N, K;

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] A(String s) {
		String[] ss = s.trim().split("\\s+");
		return new int[] { I(ss[0]), I(ss[1]) };
	}

	public static int CntCutTree() {
		return cntCutTree(0, new boolean[N]);
	}

	private static int cntCutTree(int n, boolean[] f) {
		if (n == N) return score(f) ? 1 : 0;
		f[n] = true;
		int v = cntCutTree(n + 1, f);
		f[n] = false;
		v += cntCutTree(n + 1, f);
		return v;
	}

	private static boolean score(boolean[] f) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (f[i]) {
				for (int j = 0; j < N; j++) {
					if (!f[j] && e[i][j]) cnt++;
				}
			}
		}
		return cnt <= K;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] p = A(in.nextLine());
		N = p[0];
		K = p[1];
		e = new boolean[N][N];
		for (int i = 0; i < N - 1; i++) {
			p = A(in.nextLine());
			e[p[0] - 1][p[1] - 1] = true;
			e[p[1] - 1][p[0] - 1] = true;
		}
		System.out.println(CntCutTree());
		in.close();
	}

}
