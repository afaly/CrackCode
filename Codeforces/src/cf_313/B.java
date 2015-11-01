package cf_313;

import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a1 = in.nextInt(), b1 = in.nextInt(), a2 = in.nextInt(), b2 = in
				.nextInt(), a3 = in.nextInt(), b3 = in.nextInt();;
		if ((a2 + a3 <= a1 && b2 <= b1 && b3 <= b1)
				|| (b2 + a3 <= a1 && a2 <= b1 && b3 <= b1)
				|| (a2 + b3 <= a1 && b2 <= b1 && a3 <= b1)
				|| (b2 + b3 <= a1 && a2 <= b1 && a3 <= b1)
				|| (a2 + a3 <= b1 && b2 <= a1 && b3 <= a1)
				|| (b2 + a3 <= b1 && a2 <= a1 && b3 <= a1)
				|| (a2 + b3 <= b1 && b2 <= a1 && a3 <= a1)
				|| (b2 + b3 <= b1 && a2 <= a1 && a3 <= a1)) System.out
				.println("YES");
		else
			System.out.println("NO");
		in.close();
	}
}
