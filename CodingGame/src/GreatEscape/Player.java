package GreatEscape;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
public class Player {

	private static final int GROUND = 3, GOAL = 10;
	private static int w, h, playerCount, myId;

	private static int[][] IDXS;
	private static boolean[][] f;
	private static int[] px, py, pw;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		w = in.nextInt(); // width of the board
		h = in.nextInt(); // height of the board
		playerCount = in.nextInt(); // number of players (2 or 3)
		myId = in.nextInt(); // id of my player (0 = 1st player, 1 = 2nd
								// player, ...)
		f = new boolean[100][100];
		px = new int[playerCount];
		py = new int[playerCount];
		pw = new int[playerCount];

		// game loop
		while (true) {
			int[][] m = Intialize();
			m = setGoals(m);

			for (int i = 0; i < playerCount; i++) {
				px[i] = in.nextInt(); // x-coordinate of the player
				py[i] = in.nextInt(); // y-coordinate of the player
				pw[i] = in.nextInt(); // number of walls available for player
			}

			int wallCount = in.nextInt(); // number of walls on the board
			int wx, wy;
			boolean wo;
			for (int i = 0; i < wallCount; i++) {
				wx = in.nextInt(); // x-coordinate of the wall
				wy = in.nextInt(); // y-coordinate of the wall
				wo = in.next().equals("H"); // wall orientation ('H' or 'V')
				makeWall(wx, wy, wo);
			}
			// printWalls();
			System.out.println(nextMove(px[myId], py[myId]));
		}
	}

	private static int[] dl = { 1, 2, 3, 4, 5, 6, 7, 8 };

	private static int cntMinSteps(int i, int j, int id) {
		int cnt = 0;
		if (id == 0) {
			for (int k = i; k < w - 1; k++) {
				if (f[toIdx(k, j)][toIdx(k + 1, j)])
					cnt++;
				cnt++;
			}
			return cnt;
		} else if (id == 1) {
			for (int k = i; k > 0; k--) {
				if (f[toIdx(k, j)][toIdx(k - 1, j)])
					cnt++;
				cnt++;
			}
			return cnt;

		} else if (playerCount == 3 && id == 2) {
			for (int k = j; k > 0; k--) {
				if (f[toIdx(i, k)][toIdx(i, k - 1)])
					cnt++;
				cnt++;
			}
			return cnt;
		} else
			return 0;
	}

	private static int ahead() {
		int[] cnt = new int[playerCount];
		for (int i = 0; i < playerCount; i++)
			if (!valid(px[i], py[i]))
				cnt[i] = 100;
			else
				cnt[i] = cntMinSteps(px[i], py[i], i);
		if (playerCount == 3) {
			if (cnt[myId] > cnt[(myId + 1) % playerCount]
					&& cnt[myId] > cnt[(myId + 2) % playerCount]) {
				if (cnt[(myId + 1) % playerCount] < cnt[(myId + 2)
						% playerCount]) {
					return (myId + 1) % playerCount;
				} else {
					return (myId + 2) % playerCount;
				}
			} else if (cnt[myId] > cnt[(myId + 1) % playerCount]) {
				return (myId + 1) % playerCount;
			} else if (cnt[myId] > cnt[(myId + 2) % playerCount]) {
				return (myId + 2) % playerCount;
			} else {
				return myId;
			}
		} else {
			if (cnt[myId] > cnt[(myId + 1) % playerCount]) {
				return (myId + 1) % playerCount;
			} else
				return myId;
		}

	}

	private static String nextMove(int i, int j) {
		int aId = ahead();
		if (aId != myId) {
			if (aId == 0) {
				if (py[aId] < h - 1)
					return (px[aId] + 1) + " " + py[aId] + " V";
				else
					return (px[aId] + 1) + " " + (py[aId] - 1) + " V";
			} else if (aId == 1) {
				if (py[aId] > 0)
					return (px[aId] - 1) + " " + py[aId] + " V";
				else
					return (px[aId] - 1) + " " + (py[aId] - 1) + " V";
			} else if (aId == 2) {
				if (px[aId] > 0)
					return (px[aId] - 1) + " " + (py[aId] + 1) + " H";
				else
					return (px[aId] - 1) + " " + (py[aId] + 1) + " H";
			}
		}
		if (myId == 0) {
			if (valid(i + 1, j) && !isThereWall(toIdx(i, j), toIdx(i + 1, j))) {
				return "RIGHT";
			} else {
				int dy = 0;
				boolean found = false;
				for (int k = 0; k < dl.length && !found; k++) {
					if (valid(i, j + dl[k])
							&& !isThereWall(toIdx(i, j + dl[k]),
									toIdx(i + 1, j + dl[k]))) {
						dy = dl[k];
						found = true;
					} else if (valid(i, j - dl[k])
							&& !isThereWall(toIdx(i, j - dl[k]),
									toIdx(i + 1, j - dl[k]))) {
						dy = -dl[k];
						found = true;
					}
				}
				if (dy < 0)
					return "UP";
				else
					return "DOWN";
			}
		} else if (myId == 1) {
			if (valid(i - 1, j) && !isThereWall(toIdx(i, j), toIdx(i - 1, j))) {
				return "LEFT";
			} else {
				int dy = 0;
				boolean found = false;
				for (int k = 0; k < dl.length && !found; k++) {
					if (valid(i, j + dl[k])
							&& !isThereWall(toIdx(i, j + dl[k]),
									toIdx(i - 1, j + dl[k]))) {
						dy = dl[k];
						found = true;
					} else if (valid(i, j - dl[k])
							&& !isThereWall(toIdx(i, j - dl[k]),
									toIdx(i - 1, j - dl[k]))) {
						dy = -dl[k];
						found = true;
					}
				}
				if (dy < 0)
					return "UP";
				else
					return "DOWN";
			}
		} else {
			if (valid(i, j - 1) && !isThereWall(toIdx(i, j), toIdx(i, j - 1))) {
				return "UP";
			} else {
				int dx = 0;
				boolean found = false;
				for (int k = 0; k < dl.length && !found; k++) {
					if (valid(i + dl[k], j)
							&& !isThereWall(toIdx(i + dl[k], j),
									toIdx(i + dl[k], j - 1))) {
						dx = dl[k];
						found = true;
					} else if (valid(i - dl[k], j)
							&& !isThereWall(toIdx(i - dl[k], j),
									toIdx(i - dl[k], j - 1))) {
						dx = -dl[k];
						found = true;
					}
				}
				if (dx < 0)
					return "LEFT";
				else
					return "RIGHT";
			}
		}
	}

	private static boolean isThereWall(int i, int j) {
		if (i >= 0 && i < 100 && j >= 0 && j < 100)
			return f[i][j];
		return true;
	}

	private static boolean valid(int i, int j) {
		return i >= 0 && i < w && j >= 0 && j < h;
	}

	public static void printWalls() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (f[i][j])
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
		}
	}

	private static void makeWall(int i, int j, boolean horizontalFlag) {
		int x, y;
		if (horizontalFlag) {
			x = toIdx(i, j);
			y = toIdx(i, j - 1);
			f[x][y] = true;
			f[y][x] = true;
			x = toIdx(i, j - 1);
			y = toIdx(i + 1, j - 1);
			f[x][y] = true;
			f[y][x] = true;
		} else {
			x = toIdx(i, j);
			y = toIdx(i - 1, j);
			f[x][y] = true;
			f[y][x] = true;
			x = toIdx(i, j + 1);
			y = toIdx(i - 1, j + 1);
			f[x][y] = true;
			f[y][x] = true;
		}
	}

	private static int toIdx(int i, int j) {
		// System.out.println("ACESS:  " + IDXS[i][j]);
		if (valid(i, j))
			return IDXS[i][j];
		else
			return -1;
	}

	private static int[][] Intialize() {
		int[][] m = new int[w][h];
		IDXS = new int[w][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				m[i][j] = GROUND;
				IDXS[i][j] = (i * 10) + j;
			}
		}
		return m;
	}

	private static int[][] setGoals(int[][] m) {
		if (myId == 0) {
			for (int i = 0; i < h; i++)
				m[w - 1][i] = GOAL;
		} else if (myId == 1) {
			for (int i = 0; i < h; i++)
				m[0][i] = GOAL;
		} else if (myId == 2) {
			for (int i = 0; i < w; i++)
				m[i][h - 1] = GOAL;
		}
		return m;
	}
}
