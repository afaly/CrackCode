package hackerRank;

import java.util.Scanner;

public class A {

	public static int Max(int a, int b, int c) {
		if (a == 1) {
			if (b == 1 || c == 1) return a + b + c;
			else return (a + b) * c;
		} else if (b == 1) {
			if (a > c) return a * (b + c);
			else {
				if (c == 1) return a + b + c;
				else return (a + b) * c;
			}
		} else if (c == 1) {
			return a * (b + c);
		} else return a * b * c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		System.out.println(Max(a, b, c));

		in.close();
	}

}
