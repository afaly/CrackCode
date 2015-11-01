package cf_288;

import java.util.Scanner;

public class A {

	private static int N, M, K;
	private static boolean[][] m;

	private static boolean check(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M && m[i][j];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split(" ");
		N = Integer.parseInt(ss[0]);
		M = Integer.parseInt(ss[1]);
		K = Integer.parseInt(ss[2]);
		m = new boolean[N][M];
		boolean found = false;
		int k;
		for (k = 0; k < K && !found; k++) {
			ss = in.nextLine().split(" ");
			int i = Integer.parseInt(ss[0]) - 1;
			int j = Integer.parseInt(ss[1]) - 1;
			m[i][j] = true;
			found = check(i - 1, j - 1) && check(i - 1, j) && check(i, j - 1);
			found |= check(i - 1, j) && check(i - 1, j + 1) && check(i, j + 1);
			found |= check(i, j - 1) && check(i + 1, j - 1) && check(i + 1, j);
			found |= check(i, j + 1) && check(i + 1, j) && check(i + 1, j + 1);
		}
		if(found)System.out.println(k);
		else System.out.println(0);
		in.close();
	}
}
