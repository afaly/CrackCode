package cf_314;

import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[N];

		for (int i = 0; i < N; i++) {
			n[i] = I(s[i]);
		}
		System.out.println(Math.abs(n[0] - n[1]) + " "
				+ Math.abs(n[0] - n[N - 1]));
		for (int i = 1; i < N - 1; i++) {
			System.out
					.println(Math.min(Math.abs(n[i] - n[i - 1]),
							Math.abs(n[i] - n[i + 1]))
							+ " "
							+ Math.max(Math.abs(n[i] - n[0]),
									Math.abs(n[i] - n[N - 1])));
		}
		System.out.println(Math.abs(n[N - 1] - n[N - 2]) + " "
				+ Math.abs(n[0] - n[N - 1]));
		in.close();
	}

}
