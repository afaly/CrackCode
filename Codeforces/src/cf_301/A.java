package cf_301;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		char[] c = in.nextLine().toCharArray();
		char[] p = in.nextLine().toCharArray();
		int total = 0;
		for (int i = 0; i < N; i++) {
			int v1 = c[i] - '0';
			int v2 = p[i] - '0';

			total += Math.min(
					Math.min(Math.abs(v1 - v2), Math.abs((9 - v1) + v2 + 1)),
					Math.abs((9 - v2) + v1 + 1));
		}
		System.out.println(total);
		in.close();
	}
}
