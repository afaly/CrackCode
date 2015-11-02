package dynamic;

import static java.lang.Math.max;

import java.util.Arrays;
import java.util.Random;

public class LIS<T extends Comparable<T>> {

	private T[] l;
	private static boolean[] f;
	private int[][] mem;
	private static int size;

	public static void taken() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for (boolean b : f) {
			if (b) sb.append("*  ");
			else sb.append("   ");
		}
		System.out.println(sb.toString());
	}

	public int lis(T[] list) {
		size = list.length;
		l = list;
		f = new boolean[size];
		return lis(0, 0);
	}

	private int lis(int i, int pre) {
		if (i == size) return 0;
		int cnt1 = l[i].compareTo(l[pre]) >= 0 ? 1 + lis(i + 1, i) : -1;
		int cnt2 = lis(i + 1, pre);
		return max(cnt1, cnt2);
	}

	public int lisDP(T[] list) {
		size = list.length;
		l = list;
		f = new boolean[size];
		mem = new int[size][size];
		for (int i = 0; i < size; i++)
			Arrays.fill(mem[i], -1);
		return lisDP(0, 0);
	}

	private int lisDP(int i, int pre) {
		if (i == size) return 0;
		if (mem[i][pre] >= 0) return mem[i][pre];
		int cnt1 = l[i].compareTo(l[pre]) >= 0 ? 1 + lisDP(i + 1, i) : -1;
		int cnt2 = lisDP(i + 1, pre);
		mem[i][pre] = max(cnt1, cnt2);
		return mem[i][pre];
	}

	public static void main(String[] args) {
		LIS<Integer> obj = new LIS<Integer>();
		Integer[] l = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(obj.lisDP(l));
		Integer[] ll = new Integer[2000];
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < ll.length; i++)
			ll[i] = r.nextInt(10);

		System.out.println(Arrays.toString(ll));
		int v = obj.lisDP(ll);
		taken();
		System.out.println("LIS : " + v);
	}
}
