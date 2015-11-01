package cf_296;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = 0;

		long cnt = 0;
		while (a != b && b > 0) {
			cnt += a / b;
			c = a % b;
			a = b;
			b = c;
		}

		System.out.println(cnt);
		in.close();
	}

}
