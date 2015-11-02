package dynamic;

import java.util.Scanner;

public class StockMaximize {

	private static int[] p;
	private static long[][] mem;
	private static int N;

	public static long StockGuru(int[] prices) {
		p = prices;
		N = prices.length;
		int MAX = prices[N - 1];
		long profit = 0l;
		for (int i = N - 2; i >= 0; i--) {
			if (MAX > p[i]) profit += (MAX - p[i]);
			MAX = Math.max(MAX, p[i]);
		}
		return profit;
	}

	public static long StockGuruDP(int[] prices) {
		p = prices;
		N = prices.length;
		mem = new long[N][N];
		return Math.max(stockGuru(0, 0, 0), 0);
	}

	private static long stockGuru(int i, int ct, int st) {
		if (i == N) return st > 0 ? Integer.MIN_VALUE : 0;
		if (mem[i][st] > 0) return mem[i][st];
		mem[i][st] = stockGuru(i + 1, ct, st);
		if (st > 0) mem[i][st] = Math.max(mem[i][st], stockGuru(i + 1, 0, 0)
				+ ((st * p[i]) - ct));
		if (i < N - 1) mem[i][st] = Math.max(mem[i][st],
				stockGuru(i + 1, ct + p[i], st + 1));
		return mem[i][st];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine().trim());
		while (T-- > 0) {
			int N = I(in.nextLine().trim());
			String[] s = in.nextLine().split("\\s+");
			int[] n = new int[N];
			for (int i = 0; i < N; i++)
				n[i] = I(s[i]);
			System.out.println(StockGuru(n));
			System.out.println(StockGuruDP(n));
		}
		in.close();
	}

}
