package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UVA_010306_EConis {

	private static int[][] c, f;
	private static int N, V;
	private static Map<Integer, Integer> num;

	public static void Init() {
		num = new HashMap<Integer, Integer>();
		for (int i = 0; i <= 300; i++)
			num.put(i * i, i);
	}

	private static void Populate(int val) {
		V = val * val;
		ArrayList<Integer> lx = new ArrayList<Integer>();
		ArrayList<Integer> ly = new ArrayList<Integer>();
		for (int i = 0; i <= val; i++) {
			int x = i * i, y = V - x;
			if (num.containsKey(y)) {
				lx.add(i);
				ly.add(num.get(y));
			}
		}
		int M = lx.size(), j = 0;
		f = new int[M][2];
		Iterator<Integer> itx = lx.iterator();
		Iterator<Integer> ity = ly.iterator();
		System.out.println("Size of F : " + M);
		while (itx.hasNext() && ity.hasNext()) {
			f[j][0] = itx.next();
			f[j][1] = ity.next();
			System.out.println(f[j][0] + " , " + f[j][1]);
			j++;
		}
	}

	public static long CntChange(int[][] coins, int val) {
		c = coins;
		N = coins.length;
		V = val * val;
		Populate(val);
		long[][] dp = new long[V + 1][V + 1];
		for (long[] t : dp)
			Arrays.fill(t, 1000000000);
		for (int i = 0; i < N; i++) {
			for (int j = 1; j * c[i][0] <= 300 && j * c[i][1] <= 300
					&& j <= 300; j++)
				dp[j * c[i][0]][j * c[i][1]] = Math.min(dp[j * c[i][0]][j
						* c[i][1]], j);
		}
		return dp[N][V];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Init();
		int[][] coins = { { 0, 2 }, { 2, 0 }, { 2, 1 } };
		System.out.println("VALUE : " + CntChange(coins, 20));
		in.close();
	}

}
