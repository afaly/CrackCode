package cf_287;

import java.util.Scanner;

public class AmrPins {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split(" ");
		long r, x, y, a, b;
		r = Long.parseLong(ss[0]);
		x = Long.parseLong(ss[1]);
		y = Long.parseLong(ss[2]);
		a = Long.parseLong(ss[3]);
		b = Long.parseLong(ss[4]);

		double d = Math.sqrt(Math.pow(a - x, 2.0) + Math.pow(b - y, 2.0));
		System.out.println(Math.ceil(d / (2 * r)));
		in.close();
	}

}
