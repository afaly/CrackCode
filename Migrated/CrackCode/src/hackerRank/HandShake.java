package hackerRank;

import java.util.Scanner;

public class HandShake {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N, T = in.nextInt();
		for (int t = 0; t < T; t++) {
			N = in.nextInt();
			System.out.println((N * (N - 1)) >> 1);
		}
		in.close();
	}
}
