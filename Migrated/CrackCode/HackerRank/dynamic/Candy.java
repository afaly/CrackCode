package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Candy {

	public static int minCandy(int N, int[] n) {
		int[] c = new int[N];
		Arrays.fill(c, 1);

		for (int i = 1; i < N; i++)
			if (n[i] > n[i - 1]) c[i] = c[i - 1] + 1;

		int totCount = 0;
		for (int i = N - 2; i >= 0; i--)
			if (n[i] > n[i + 1]) c[i] = Math.max(c[i], c[i + 1] + 1);

		for (int i = 0; i < N; i++)
			totCount += c[i];
		return totCount;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		int[] n = new int[N];
		for (int i = 0; i < N; i++)
			n[i] = I(in.nextLine());
		System.out.println(minCandy(N, n));
		in.close();
	}

}
