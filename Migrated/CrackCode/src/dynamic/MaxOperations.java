package dynamic;

import java.util.Arrays;

public class MaxOperations {

	private static int[] a;
	private static long[][] mem;
	private static final long OO = Long.MIN_VALUE;

	public static long Group(int[] array) {
		a = array;
		mem = new long[array.length][array.length];
		for (int i = 0; i < array.length; i++)
			Arrays.fill(mem[i], OO);
		return group(0, array.length - 1);
	}

	private static long group(int i, int j) {
		if (i == j) return a[i];
		if (mem[i][j] != OO) {
			System.out.println("MEM");
			return mem[i][j];
		}
		long max = Long.MIN_VALUE;
		for (int k = i; k < j; k++) {
			long v = group(i, k) + group(k + 1, j);
			if ((v & 1) == 0) v >>= 1;
			else v -= 3;
			if (v > max) max = v;
		}
		mem[i][j] = max;
		return mem[i][j];
	}

	public static void main(String[] args) {
		System.out.println(Group(new int[] { 4, 4, 2, 4, 4, 2, 4, 4, 2 }));
	}

}
