package dynamic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LaserArchitect {

	private static int[] X, Y;
	private static int[][] M;
	private static int[] mem;
	private static int m, n;

	public static int Shoot(int nn, int mm, int[] x, int[] y) {
		n = nn;
		m = mm;
		X = x;
		Y = y;
		M = new int[n][n];
		mem = new int[1 << n];
		Arrays.fill(mem, -1);
		Pre();
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// System.out.println("(" + i + " , " + j + ")  : "
		// + print10(M[i][j]));
		// }
		// }
		return Shoot((1 << n) - 1);
	}

	static String print10(int n) {
		return (n + " : " + Integer.toBinaryString(n));
	}

	private static void Pre() {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int msk = (1 << n) - 1;
				msk &= ~(1 << i);
				msk &= ~(1 << j);
				int distx = X[i] - X[j];
				int disty = Y[i] - Y[j];
				for (int k = 0; k < n; k++) {
					if (k != i && k != j) {
						// On the same line.
						if (distx * (Y[i] - Y[k]) == disty * (X[i] - X[k])) {
							msk &= ~(1 << k);
						}
					}
				}
				M[i][j] = msk;
				M[j][i] = msk;
			}
		}
	}

	private static int cardinality(int x) {
		int cnt = 0;
		while (x > 0) {
			if ((x & 1) == 1) cnt++;
			x >>= 1;
		}
		return cnt;
	}

	private static int[] cardinalPositions(int x, int card) {
		int[] cnt = new int[card];
		int i = 0, j = 0;
		while (x > 0) {
			if ((x & 1) == 1) cnt[j++] = i;
			x >>= 1;
			i++;
		}
		return cnt;
	}

	private static int Shoot(int msk) {
		int card = cardinality(msk);
		if (n - card >= m) return 0;
		if (mem[msk] != -1) return mem[msk];
		int[] pos = cardinalPositions(msk, card);
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < pos.length; i++) {
			for (int j = i + 1; j < pos.length; j++) {
				ret = Math.min(ret, 1 + Shoot(msk & M[pos[i]][pos[j]]));
			}
		}
		mem[msk] = ret;
		return (mem[msk] == Integer.MAX_VALUE) ? mem[msk] = 1 : mem[msk];
	}

	/*-
	2
	4
	4
	0 0
	0 1
	1 0
	1 1
	9
	7
	0 0
	1 1
	0 2
	2 0
	2 2
	3 0
	3 1
	3 2
	3 4
	
	Solution:
	 #1 = 2
	 #2 = 2
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(new File("data/laser_architect.sol"));
		Scanner in = new Scanner(new File("data/laser_architect.input"));
		// Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int nn = in.nextInt();
			int mm = in.nextInt();
			int[] x = new int[nn];
			int[] y = new int[nn];
			for (int i = 0; i < nn; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}

			int val = Shoot(nn, mm, x, y);
			if (t != 1) fw.write("\n");
			fw.write(String.format("Case #%d:\n%d\n", t, val));
			// if (t != 1) System.out.println();
			// System.out.println(String.format("Case #%d:\n%d", t, val));
		}

		in.close();
		fw.flush();
		fw.close();
	}

}
