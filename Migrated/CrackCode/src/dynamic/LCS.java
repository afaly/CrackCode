package dynamic;

import static java.lang.Math.max;

public class LCS {

	private static char[] A, B;

	public static int lcs(String a, String b) {
		if (a == null || b == null || a.length() <= 0 || b.length() <= 0) return 0;
		A = a.toCharArray();
		B = b.toCharArray();
		return lcs(0, 0);
	}

	private static int lcs(int i, int j) {
		if (i >= A.length || j >= B.length) return 0;
		if (A[i] == B[j]) return 1 + lcs(i + 1, j + 1);

		int cnt1 = lcs(i + 1, j);
		int cnt2 = lcs(i, j + 1);

		return max(cnt1, cnt2);
	}

	private static int[][] mem;

	public static int lcsDP(String a, String b) {
		if (a == null || b == null || a.length() <= 0 || b.length() <= 0) return 0;
		A = a.toCharArray();
		B = b.toCharArray();
		mem = new int[a.length()][b.length()];
		return lcsDP(0, 0);
	}

	private static int lcsDP(int i, int j) {
		if (i >= A.length || j >= B.length) return 0;

		if (mem[i][j] > 0) return mem[i][j];
		if (A[i] == B[j]) return 1 + lcsDP(i + 1, j + 1);

		int cnt1 = lcsDP(i + 1, j);
		int cnt2 = lcsDP(i, j + 1);

		mem[i][j] = max(cnt1, cnt2);
		return mem[i][j];
	}

	public static void main(String[] args) {
		System.out
				.println("COUNT: "
						+ lcsDP("AhuashdiausdBadsadsCiajsdoasdaksdlC",
								"A834729384729384B723462893472934C283479238472938472934C"));
	}

}
