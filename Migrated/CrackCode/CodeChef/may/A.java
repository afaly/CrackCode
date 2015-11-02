package may;

import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		while (T-- > 0) {
			int N = I(in.nextLine());
			String[] s = in.nextLine().split("\\s+");
			int sum = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int v = I(s[i]);
				sum += v;
				if (v < min) min = v;
			}
			if (min < 2) System.out.println("-1");
			else
				System.out.println((sum + 2) - min);
		}

		in.close();
	}
}
