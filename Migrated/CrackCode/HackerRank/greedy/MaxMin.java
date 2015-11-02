package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), K = in.nextInt(), MIN = Integer.MAX_VALUE;
		int[] n = new int[N];
		for (int i = 0; i < N; i++)
			n[i] = in.nextInt();
		Arrays.sort(n);
		for (int i = 0; i <= N - K; i++)
			MIN = Math.min(MIN, n[(i + K) - 1] - n[i]);
		System.out.println(MIN);
		in.close();
	}
}
