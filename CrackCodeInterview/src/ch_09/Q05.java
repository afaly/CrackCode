package ch_09;

public class Q05 {

	public static long Mult(int a, int b) {
		return a > b ? mult(a, b) : mult(b, a);
	}

	private static long mult(int a, int b) {
		if (b == 1) return a;
		long val = mult(a, b >> 1);
		return (b & 1) == 0 ? val + val : a + val + val;
	}

	public static void main(String[] args) {
		System.out.println(Mult(7, 7));
	}

}
