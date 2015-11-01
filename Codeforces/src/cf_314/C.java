package cf_314;

import java.util.Scanner;

public class C {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), K = I(s[1]);
		s = in.nextLine().split("\\s+");
		int[] n = new int[N];

		for (int i = 0; i < N; i++) {
			n[i] = I(s[i]);
		}
		in.close();
	}

}
