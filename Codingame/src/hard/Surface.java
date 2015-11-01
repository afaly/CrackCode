package hard;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Surface {
	public static final char LND = '#', WTR = 'O', VIS = '@';
	public static int[][] m;
	public static int L, H;
	public static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };

	private static final int RIGHT = 0xFFFF;

	public static int toInt(int i, int j) {
		return (i << 16) | (j & RIGHT);
	}

	public static int getI(int val) {
		return val >>> 16; // >>> operator 0-fills from left
	}

	public static int getJ(int val) {
		return val & RIGHT;
	}

	public static boolean valid(int i, int j) {
		return i >= 0 && i < H && j >= 0 && j < L;
	}

	public static int floodfillR(int i, int j, int mark) {
		if (valid(i, j) && m[i][j] == 0) {
			m[i][j] = mark;
			int res = 1;
			for (int k = 0; k < 4; k++)
				res += valid(i + dx[k], j + dy[k])
						&& m[i + dx[k]][j + dy[k]] == 0 ? floodfillR(i + dx[k],
						j + dy[k], mark) : 0;
			return res;
		} else return 0;
	}

	public static int floodfillI(int i, int j, int mark) {
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		stack.push(toInt(i, j));
		while (!stack.isEmpty()) {
			int val = stack.pop();
			i = getI(val);
			j = getJ(val);
			if (valid(i, j) && m[i][j] == 0) {
				m[i][j] = mark;
				res++;
				for (int k = 0; k < 4; k++) {
					if (valid(i + dx[k], j + dy[k])
							&& m[i + dx[k]][j + dy[k]] == 0) {
						stack.push(toInt(i + dx[k], j + dy[k]));
					}
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		L = in.nextInt();
		H = in.nextInt();
		m = new int[H][L];
		char[] x;
		int mark = 1;
		HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();
		for (int i = 0; i < H; i++) {
			x = in.next().toCharArray();
			// System.err.println(new String(x));
			for (int j = 0; j < L; j++) {
				if (x[j] == LND) m[i][j] = -1;
				else m[i][j] = 0;
			}
		}
		int N = in.nextInt();
		for (int k = 0; k < N; k++) {
			int j = in.nextInt();
			int i = in.nextInt();
			// System.err.println(i + ", " + j);
			if (m[i][j] == -1) {
				System.out.println(0);
			} else if (m[i][j] > 0) {
				System.out.println(val.get(m[i][j]));
			} else {
				int res = floodfillI(i, j, mark);
				val.put(mark, res);
				mark++;
				System.out.println(val.get(m[i][j]));
			}

		}

		in.close();
	}
}
