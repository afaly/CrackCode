package cf_290;

import java.util.Scanner;

public class B {

	public static char[][] c;
	private static int n, m;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[][] f;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split(" ");
		n = Integer.parseInt(ss[0]);
		m = Integer.parseInt(ss[1]);
		c = new char[n][m];
		for (int i = 0; i < n; i++)
			c[i] = in.nextLine().toCharArray();

		f = new int[n][m];

		boolean found = false;
		for (int i = 0; i < n && !found; i++) {
			for (int j = 0; j < m && !found; j++) {
				if (f[i][j] == 0) {
					char k = c[i][j];
					found |= visit(i, j, k, 0);
				}
			}
		}
		if (found)
			System.out.println("Yes");
		else
			System.out.println("No");

		in.close();
	}

	private static boolean visit(int i, int j, char k, int cnt) {
		if (check(i, j)) {
			if (c[i][j] == k) {
				if (f[i][j] == 0) {
					f[i][j] = cnt;
					boolean stat = false;
					for (int x = 0; x < 4; x++) {
						stat |= visit(i + dx[x], j + dy[x], k, cnt + 1);
					}
					return stat;
				} else {
					return (cnt - f[i][j]) >= 4;
				}
			}
			return false;
		}
		return false;
	}

	private static boolean check(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}
}
