package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class PearlStore {

	private static int[] prices, amount;
	private static long[][] mem;
	private static int Size;

	public static long buyCheapest(int[] _prices, int[] _amount) {
		Size = _prices.length;
		prices = _prices;
		amount = _amount;
		mem = new long[Size][Size];
		for (int i = 0; i < Size; i++)
			Arrays.fill(mem[i], -1l);
		return buyCheapest(0, 0, 0);
	}

	private static long buyCheapest(int a, int t, int i) {
		if (i == Size) return a == 0 ? 0 : prices[i - 1] * (a + 10);
		if (mem[i][t] != -1) return mem[i][t];
		long v1 = (prices[i] * (amount[i] + a + 10)) + buyCheapest(0, 0, i + 1);
		long v2 = buyCheapest(a + amount[i], t + 1, i + 1);
		mem[i][t] = Math.min(v1, v2);
		return mem[i][t];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		for (int i = 0; i < N; i++) {
			int C = Integer.parseInt(in.nextLine());
			int[] p = new int[C];
			int[] a = new int[C];
			for (int j = 0; j < C; j++) {
				String[] ss = in.nextLine().split(" ");
				a[j] = Integer.parseInt(ss[0]);
				p[j] = Integer.parseInt(ss[1]);
			}
			System.out.println(buyCheapest(p, a));
		}

		in.close();
	}

}
