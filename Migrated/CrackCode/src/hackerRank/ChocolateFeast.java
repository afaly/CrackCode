package hackerRank;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int N, C, M, B, V, X;
		for (int t = 0; t < T; t++) {
			N = in.nextInt();
			C = in.nextInt();
			M = in.nextInt();
			B = N / C;
			V = B;
			while (B >= M) {
				X = (B / M);
				B = (B % M) + X;
				V += X;
			}
			System.out.println(V);
		}
		in.close();
	}
}
