package edu;

public class TCO_Pearls {

	private static int[] p, c, q;
	private static int[][] mem;
	private static int N;

	public static int Pearls(int[] prices, int[] quantity) {
		N = prices.length;
		p = prices;
		q = quantity;
		c = new int[N];
		c[0] = q[0];
		for (int i = 1; i < N; i++)
			c[i] = q[i] + c[i - 1];
		return pearls(quantity, 0);
	}

	public static int Pearls_Mod(int[] prices, int[] quantity) {
		N = prices.length;
		p = prices;
		q = quantity;
		c = new int[N];
		mem = new int[N][N];
		c[0] = q[0];
		for (int i = 1; i < N; i++)
			c[i] = q[i] + c[i - 1];
		return pearls(0, 0);
	}

	private static int pearls(int[] x, int i) {
		if (i == N - 1) return score(x);
		int cst_leave = pearls(x, i + 1);
		int temp = x[i];
		x[i + 1] += x[i];
		x[i] = 0;
		int cst_trans = pearls(x, i + 1);
		x[i] = temp;
		x[i + 1] -= x[i];
		return Math.min(cst_leave, cst_trans);
	}

	private static int pearls(int i, int j) {
		if (j == N - 1) return (((c[j] - c[i]) + q[i]) + 10) * p[j];
		if (mem[i][j] > 0) return mem[i][j];
		mem[i][j] = pearls(i, j + 1);
		mem[i][j] = Math.min(mem[i][j], pearls(j + 1, j + 1)
				+ (((c[j] - c[i]) + q[i]) + 10) * p[j]);
		return mem[i][j];
	}

	private static int score(int[] x) {
		int val = 0;
		for (int i = 0; i < x.length; i++)
			val += x[i] > 0 ? (x[i] + 10) * p[i] : 0;
		return val;
	}

	public static int Pearls_Dp(int[] prices, int[] quantity) {
		N = prices.length;
		p = prices;
		q = quantity;
		c = new int[N];
		mem = new int[N + 1][N + 1];
		c[0] = q[0];
		for (int i = 1; i < N; i++)
			c[i] = q[i] + c[i - 1];

		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				mem[i][j] = Math.min(
						mem[i][j - 1] + p[j - 1] * (q[j - 1] + 10),
						(((c[j - 1] - c[i - 1]) + q[i - 1]) + 10) * p[j - 1]);
			}
		}
		return mem[N][N];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 4 };
		int[] quantity = { 100, 100, 100 };
		System.out.println("Min Expense : " + Pearls(prices, quantity));
		System.out.println("Min Expense : " + Pearls_Mod(prices, quantity));
		System.out.println("Min Expense : " + Pearls_Dp(prices, quantity));
	}

}
