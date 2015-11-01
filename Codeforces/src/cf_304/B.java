package cf_304;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[N];
		for (int i = 0; i < N; i++)
			n[i] = I(s[i]);

		Arrays.sort(n);
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			if (n[i] <= n[i - 1]) {
				int v = ((n[i - 1] - n[i]) + 1);
				n[i] += v;
				cnt += v;
			}
		}
		System.out.println(cnt);
		in.close();
	}
}
