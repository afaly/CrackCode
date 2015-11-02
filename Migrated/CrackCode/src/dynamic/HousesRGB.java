package dynamic;


public class HousesRGB {

	private static final int R = 0, G = 1, B = 2, OO = Integer.MAX_VALUE;
	private static int[][] h;
	private static int size;

	public static int Solve(int[][] housesCost) {
		if (housesCost == null || housesCost.length == 0) return -1;
		h = housesCost;
		size = h.length;
		int r = h[0][R] + solve(1, R);
		int g = h[0][G] + solve(1, G);
		int b = h[0][B] + solve(1, B);
		return Math.min(r, Math.min(g, b));
	}

	private static int solve(int p, int c) {
		if (p == size) return 0;
		if (c == R) return Math.min(h[p][G] + solve(p + 1, G), h[p][B]
				+ solve(p + 1, B));
		else if (c == G) return Math.min(h[p][R] + solve(p + 1, R),
				h[p][B] + solve(p + 1, B));
		else return Math.min(h[p][G] + solve(p + 1, G),
				h[p][R] + solve(p + 1, R));
	}

	private static int[][] mem;

	public static int SolveDP(int[][] housesCost) {
		if (housesCost == null || housesCost.length == 0) return -1;
		h = housesCost;
		size = h.length;
		mem = new int[size][3];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < 3; j++)
				mem[i][j] = -1;
		mem[0][R] = h[0][R] + solveDP(1, R);
		mem[0][G] = h[0][G] + solveDP(1, G);
		mem[0][B] = h[0][B] + solveDP(1, B);
		return Math.min(mem[0][R], Math.min(mem[0][G], mem[0][B]));
	}

	private static int solveDP(int p, int c) {
		if (p == size) return 0;
		int ret = OO;
		if (c >= 0 && mem[p][c] != -1) {
			System.out
					.println("Mem: " + mem[p][c] + "( " + p + " , " + c + ")");
			return mem[p][c];
		}
		if (c != R) ret = Math.min(ret, solveDP(p + 1, R) + h[p][R]);
		if (c != G) ret = Math.min(ret, solveDP(p + 1, G) + h[p][G]);
		if (c != B) ret = Math.min(ret, solveDP(p + 1, B) + h[p][B]);
		mem[p][c] = ret;
		return ret;
	}

	public static void main(String[] args) {
		int[][] hh = { { 1, 20, 15 }, { 0, 20, 10 }, { 7, 8, 9 },
				{ 10, 50, 10 }, { 1, 20, 15 }, { 0, 20, 10 }, { 70, 8, 9 },
				{ 10, 50, 10 }, { 1, 20, 150 }, { 0, 20, 10 }, { 7, 80, 9 },
				{ 10, 50, 10 }, { 1, 2, 15 }, { 10, 20, 10 }, { 7, 8, 90 },
				{ 10, 50, 10 }, { 1, 20, 15 }, { 0, 200, 10 }, { 7, 8, 9 },
				{ 10, 50, 10 } };
		System.out.println("Solution: " + Solve(hh));
		System.out.println("Solution: " + SolveDP(hh));
	}

}
