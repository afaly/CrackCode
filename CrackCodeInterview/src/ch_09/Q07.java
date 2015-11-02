package ch_09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Q07 {

	public enum Color {
		Black, White, Red, Yellow, Green
	}

	private static HashSet<Long> vis;
	private static int[][] m;
	private static long mask = 0xFFFFFFFFL;
	private static int[] dx = { 0, 0, 1, -1 }, dy = { -1, 1, 0, 0 };

	public static void FloodFill(int[][] map, int i, int j, int k) {
		vis = new HashSet<Long>();
		m = map;
		floodFill(i, j, k, m[i][j]);
	}

	private static long pack(int i, int j) {
		long val = ((long) i) << 32;
		val |= ((long) j) & 0xFFFFFFFFL;
		return val;
	}

	private static boolean valid(int x, int y) {
		return x >= 0 && y >= 0 && x < m.length && y < m[0].length;
	}

	private static void floodFill(int i, int j, int k, int O) {
		Stack<Long> s = new Stack<Long>();
		s.push(pack(i, j));
		while (!s.isEmpty()) {
			long pos = s.pop();
			int x = (int) (pos >> 32);
			int y = (int) (pos & mask);
			if (m[x][y] == O) {
				m[x][y] = k;
				for (int p = 0; p < dx.length; p++)
					if (valid(x + dx[p], y + dy[p])
							&& m[x + dx[p]][y + dy[p]] == O) s.push(pack(x
							+ dx[p], y + dy[p]));
			}
		}
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static void PrintScreen(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	public static void main(String[] args) {
		int N = 20;
		int[][] screen = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = 0;
			}
		}
		for (int i = 0; i < 400; i++) {
			screen[randomInt(N)][randomInt(N)] = 1;
		}
		PrintScreen(screen);
		System.out.println(screen[2][2]);
		FloodFill(screen, 2, 2, 2);
		System.out.println();
		PrintScreen(screen);
	}

}
