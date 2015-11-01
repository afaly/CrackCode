package cf_305;

import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int n = I(s[0]), m = I(s[1]), q = I(s[2]);
		char[][] g = new char[n][m];
		int[] cnt = new int[n];
		for (int i = 0; i < n; i++) {
			s = in.nextLine().split("\\s+");
			int max = 0, cur = 0;
			for (int j = 0; j < m; j++) {
				g[i][j] = s[j].charAt(0);
				if (g[i][j] == '1') cur++;
				else {
					if (cur > max) max = cur;
					cur = 0;
				}
			}
			cnt[i] = Math.max(cur, max);
		}
		for (int k = 0; k < q; k++) {
			s = in.nextLine().split("\\s+");
			int i = I(s[0]) - 1, j = I(s[1]) - 1;
			if (g[i][j] == '1') g[i][j] = '0';
			else
				g[i][j] = '1';

			int max = 0, cur = 0;
			for (int u = 0; u < m; u++) {
				if (g[i][u] == '1') cur++;
				else {
					if (cur > max) max = cur;
					cur = 0;
				}
			}
			cnt[i] = Math.max(cur, max);
			for (int l = 0; l < n; l++)
				if (cnt[l] > max) max = cnt[l];
			System.out.println(max);
		}
		in.close();
	}
}
