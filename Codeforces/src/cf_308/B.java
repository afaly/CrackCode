package cf_308;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static long I(String s) {
		return Long.parseLong(s);
	}

	private static long[] num;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		num = new long[10];
		long x;
		int i;
		for (i = 1, x = 10; i < 10; i++, x *= 10)
			num[i] = ((x - 1) * i) - num[i - 1];
		System.out.println(Arrays.toString(num));
		String s = in.nextLine();
		long n = I(s), cnt = 0, pre = 0, len = s.length(), rem = (long) (n % (long) Math
				.pow(10, len - 1));
		in.close();
	}
}
