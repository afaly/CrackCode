package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class TheCoinChangeProblem {

	public static int[] I(String s) {
		String[] ss = s.trim().split("\\s+");
		int[] n = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			n[i] = Integer.parseInt(ss[i]);
		return n;
	}

	private static int[] ch;
	private static long[][] mem;
	private static int sz;

	public static long CoinChange(int[] change, int value) {
		ch = change;
		sz = change.length;
		Arrays.sort(ch);
		mem = new long[sz][value + 1];
		return value > 0 ? coinChange(0, value) : 0;
	}

	private static long coinChange(int i, int v) {
		if (v == 0) return 1;
		if (i == sz || v < ch[i]) return 0;
		if (mem[i][v] > 0) return mem[i][v];
		mem[i][v] = coinChange(i, v - ch[i]) + coinChange(i + 1, v);
		return mem[i][v];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] p = I(in.nextLine()), n = I(in.nextLine());
		System.out.println(CoinChange(n, p[0]));
		in.close();
	}

}
