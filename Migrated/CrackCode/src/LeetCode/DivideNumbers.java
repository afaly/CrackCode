package LeetCode;

import java.util.Scanner;

public class DivideNumbers {
	public static int divide(int dividend, int divisor) {
		boolean neg_a = dividend < 0, neg_b = divisor < 0;
		long a = dividend, b = divisor;
		if (neg_a) a *= -1;
		if (neg_b) b *= -1;
		long[] val = new long[32];
		val[0] = b;
		for (int i = 1; i < 31; i++) {
			val[i] = (int) Math.min(Integer.MAX_VALUE, (val[i - 1]) << 1);
		}
		int res = 0;
		for (int i = 31; i >= 0; i--) {
			if (a >= val[i]) {
				res |= (1 << i);
				a -= val[i];
			}
		}
		return neg_a ^ neg_b ? -res : res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();

		System.out.println(divide(1 << 31, b));

		in.close();
	}
}
