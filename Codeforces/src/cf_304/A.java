package cf_304;

import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int k = I(s[0]), n = I(s[1]), w = I(s[2]);
		long val = w * (k + (k * w));
		val = val / 2;
		System.out.println(Math.max(val - n, 0));
		in.close();
	}

}
