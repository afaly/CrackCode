package edu;

public class TCO_MaximalProduct {

	public long maximalProduct(int s, int k) {
		int min = s / k;
		int rem = s % k;
		long val = (long) ((long) Math.pow(min, k - rem) * (long) Math.pow(
				min + 1, rem));
		return val;
	}

	private long[][] mem = new long[21][101];

	public long maxProduct(int s, int k) {
		if (k == 1) return s;
		if (mem[k][s] > 0) return mem[k][s];
		for (int v = 1; v <= (s - k) + 1; v++)
			mem[k][s] = Math.max(mem[k][s], v * maxProduct(s - v, k - 1));
		return mem[k][s];
	}

	public static void main(String[] args) {
		TCO_MaximalProduct p = new TCO_MaximalProduct();
		System.out.println(p.maxProduct(10, 3));
		System.out.println(p.maxProduct(10, 10));
		System.out.println(p.maxProduct(10, 1));
		System.out.println(p.maxProduct(13, 8));
		System.out.println(p.maxProduct(7, 2));
	}
}
