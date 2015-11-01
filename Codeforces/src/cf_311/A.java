package cf_311;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), min1 = in.nextInt(), max1 = in.nextInt(), min2 = in
				.nextInt(), max2 = in.nextInt(), min3 = in.nextInt(), max3 = in
				.nextInt(), M = N, tok1 = 0, tok2 = 0, tok3 = 0;

		tok1 = Math.min(M - (min2 + min3), max1);
		M -= tok1;
		tok2 = Math.min(M - min3, max2);
		M -= tok2;
		tok3 = M;
		System.out.println(tok1 + " " + tok2 + " " + tok3);
		in.close();
	}
}
