package easy;

import java.util.Arrays;
import java.util.Scanner;

public class HorseRaceDuals {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] n = new int[N];
		for (int i = 0; i < N; i++)
			n[i] = in.nextInt();
		Arrays.sort(n);
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; i++)
			dist = Math.min(dist, Math.abs(n[i] - n[i + 1]));

		System.out.println(dist);

		in.close();
	}
}
