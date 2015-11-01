package cf_292;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long s = in.nextLong();
		long d = s - (Math.abs(a) + Math.abs(b));
		if (d >= 0 && d % 2 == 0)
			System.out.println("Yes");
		else
			System.out.println("No");

		in.close();
	}

}
