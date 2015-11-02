package codeforces;

import java.util.Scanner;

public class Hopscotch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		if (y <= 0 || x <= -2 * a || x >= 2 * a || y % a == 0) System.out
				.println("-1");
		else {
			if (y < a) {
				if (x <= -a / 2.0 || x >= a / 2.0) System.out.println("-1");
				else System.out.println("1");
			} else {
				int v = (y - a) / a;
				if ((v & 1) == 0) {
					if (x <= -a / 2 || x >= a / 2) System.out.println("-1");
					else System.out.println("" + (2 + ((v / 2) * 3)));
				} else {
					if (x == 0) System.out.println("-1");
					else {
						if (x < 0) System.out.println("" + ((v / 2) * 3) + 1);
						else System.out.println("" + ((v / 2) * 3) + 2);
					}
				}
			}
		}
		in.close();
	}
}
