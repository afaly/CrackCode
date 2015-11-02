package greedy;

import java.util.Scanner;

public class ChiefHopper {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		int[] n = new int[N];
		String[] s = in.nextLine().split("\\s+");
		for (int i = 0; i < N; i++)
			n[i] = I(s[i]);

		int r = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (r < n[i]) r = Math.min(n[i], r + (n[i] + 1) / 2);
		}
		System.out.println(r);
		in.close();
	}
}
