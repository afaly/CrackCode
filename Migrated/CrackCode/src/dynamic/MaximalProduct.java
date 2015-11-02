package dynamic;

public class MaximalProduct {

	private static long[][] mem;

	public static long MaxProductDP(int SUM, int k) {
		mem = new long[k][SUM + 1];
		return maxProductDP(SUM, k - 1);
	}

	private static long maxProductDP(int s, int k) {
		if (k == 0) return s;
		if (mem[k][s] > 0) return mem[k][s];
		long ret = 1l;
		for (int i = 1; i <= (s - k); i++)
			ret = Math.max(ret, maxProduct(s - i, k - 1) * i);
		mem[k][s] = ret;
		return ret;
	}

	public static long MaxProduct(int SUM, int k) {
		return maxProduct(SUM, k - 1);
	}

	private static long maxProduct(int s, int k) {
		if (k == 0) return s;
		long ret = 1l;
		for (int i = 1; i <= (s - k); i++)
			ret = Math.max(ret, maxProduct(s - i, k - 1) * i);
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(MaxProductDP(1300, 80));
	}

}
