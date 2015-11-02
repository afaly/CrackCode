package ch_09;

public class Q02 {

	private static long[][] mem;

	public static long CountRobotDP(int x, int y) {
		mem = new long[x + 1][y + 1];
		return x == 0 && y == 0 ? 0 : cntRobotDP(x, y);
	}

	private static long cntRobotDP(int x, int y) {
		long[][] cnt = new long[x + 1][y + 1];
		cnt[0][0] = 1;
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (i > 0) cnt[i][j] += cnt[i - 1][j];
				if (j > 0) cnt[i][j] += cnt[i][j - 1];
			}
		}
		return cnt[x][y];
	}

	public static long CountRobot(int x, int y) {
		mem = new long[x + 1][y + 1];
		return x == 0 && y == 0 ? 0 : cntRobot(x, y);
	}

	private static long cntRobot(int x, int y) {
		if (x == 0 && y == 0) return 1;
		if (mem[x][y] > 0) return mem[x][y];
		long l = x > 0 ? cntRobot(x - 1, y) : 0;
		long u = y > 0 ? cntRobot(x, y - 1) : 0;
		mem[x][y] = l + u;
		return mem[x][y];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				System.out.println(i + " X " + j + " : " + CountRobot(i, j)
						+ " | " + CountRobotDP(i, j));
	}
}
