package edu;

import java.util.HashMap;
import java.util.Scanner;

public class Nim_Game {

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

	public static long[] LA(String s) {
		String[] ss = s.split("\\s+");
		long[] a = new long[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Long.parseLong(ss[i]);
		return a;
	}

	private static long[] v;
	private static int N;

	private static boolean eval(long m) {
		long val = 0, xor = 0;
		// System.out.print(m + "  > ");
		for (int k = N - 1; k >= 0; k--) {
			if ((m & 1) == 1) {
				val += v[k];
				xor ^= val;
				val = 0;
			} else {
				val += v[k];
			}
			m >>= 1;
		}
		xor ^= val;
		// System.out.println(xor);
		return xor == 0;
	}

	static class M {
		HashMap<Long, Integer> map;

		public M() {
			map = new HashMap<Long, Integer>();
		}

		public boolean contains(Long key) {
			return map.containsKey(key);
		}

		public void put(Long key, Integer value) {
			map.put(key, value);
		}

		public Integer get(Long key) {
			return map.get(key);
		}
	}

	public static M[] mem;

	public static int CntNim(int i, long m) {
		if (i == N - 1) return eval(m) ? 1 : 0;
		if (mem[i].contains(m)) return mem[i].get(m);
		int cnt = CntNim(i + 1, m) + CntNim(i + 1, m |= (1 << i));
		mem[i].put(m, cnt);
		return mem[i].get(m);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = I(in.nextLine());
		v = LA(in.nextLine());
		mem = new M[N];
		for (int i = 0; i < N; i++) {
			mem[i] = new M();
		}
		// System.out.println(eval(6));
		// System.out.println(eval(5));
		// System.out.println(eval(3));
		int cnt = CntNim(0, 0);
		System.out.println(cnt);
		in.close();
	}
}
