package medium;

import java.util.Scanner;

public class Indiana_01 {
	private static final int R = 1, T = 0, L = 2, B = -1, D = 3; // TOP, LEFT,
																	// RIGHT
	private static int[][] mat;

	public static void getMat() {
		if (mat == null) {
			mat = new int[14][3];
			// 0
			mat[0][T] = B;
			mat[0][R] = B;
			mat[0][L] = B;
			// 1
			mat[1][T] = D;
			mat[1][R] = D;
			mat[1][L] = D;
			// 2
			mat[2][T] = B;
			mat[2][R] = R;
			mat[2][L] = L;
			// 3
			mat[3][T] = D;
			mat[3][R] = B;
			mat[3][L] = B;
			// 4
			mat[4][T] = R;
			mat[4][R] = D;
			mat[4][L] = B;
			// 5
			mat[5][T] = L;
			mat[5][R] = B;
			mat[5][L] = D;
			// 6
			mat[6][T] = B;
			mat[6][R] = R;
			mat[6][L] = L;
			// 7
			mat[7][T] = D;
			mat[7][R] = D;
			mat[7][L] = B;
			// 8
			mat[8][T] = B;
			mat[8][R] = D;
			mat[8][L] = D;
			// 9
			mat[9][T] = D;
			mat[9][R] = B;
			mat[9][L] = D;
			// 10
			mat[10][T] = R;
			mat[10][R] = B;
			mat[10][L] = B;
			// 11
			mat[11][T] = L;
			mat[11][R] = B;
			mat[11][L] = B;
			// 12
			mat[12][T] = B;
			mat[12][R] = B;
			mat[12][L] = L;
			// 13
			mat[13][T] = B;
			mat[13][R] = B;
			mat[13][L] = D;
		}
	}

	public static void move(int nxt, int x, int y) {
		if (nxt == L) {
			System.out.println((x + 1) + " " + y);
		} else if (nxt == R) {
			System.out.println((x - 1) + " " + y);
		} else {
			System.out.println(x + " " + (y + 1));
		}
	}

	public static void main(String args[]) {
		getMat();
		Scanner in = new Scanner(System.in);
		int W = in.nextInt(); // number of columns.
		int H = in.nextInt(); // number of rows.
		in.nextLine();
		int[][] m = new int[H][W];
		for (int i = 0; i < H; i++) {
			String[] line = in.nextLine().split(" "); // represents a line in
														// the grid and contains
														// W integers. Each
														// integer represents
														// one room of a given
														// type.
			for (int j = 0; j < W; j++)
				m[i][j] = Integer.parseInt(line[j]);
		}
		int EX = in.nextInt(); // the coordinate along the X axis of the exit
								// (not useful for this first mission, but must
								// be read).
		in.nextLine();
		// game loop
		while (true) {
			int XI = in.nextInt();
			int YI = in.nextInt();
			String POS = in.next();
			in.nextLine();
			int room = m[YI][XI], nxt;
			if (room == 0) {
				if (POS.equalsIgnoreCase("LEFT")) {
					nxt = L;
				} else if (POS.equalsIgnoreCase("RIGHT")) {
					nxt = R;
				} else {
					nxt = T;
				}
			} else {
				if (POS.equalsIgnoreCase("LEFT")) {
					nxt = mat[room][L];
				} else if (POS.equalsIgnoreCase("RIGHT")) {
					nxt = mat[room][R];
				} else {
					nxt = mat[room][T];
				}
			}
			move(nxt, XI, YI);
		}
	}
}
