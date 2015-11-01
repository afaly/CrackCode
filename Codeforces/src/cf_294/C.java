package cf_294;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int t = 0;

		if (n + m < 3) {
			t = 0;
		} else if (2 * n <= m) {
			t = Math.min(n, m / 2);
		} else if (n >= 2 * m) {
			t = m;
		} else {
			t = n - (int) Math.ceil(Math.max(0, ((2 * n)) - m) / 3.0);
		}
		System.out.println(t);
		in.close();
	}
}
